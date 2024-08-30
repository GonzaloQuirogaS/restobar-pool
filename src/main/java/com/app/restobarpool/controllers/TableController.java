package com.app.restobarpool.controllers;

import com.app.restobarpool.dto.table.SaveTableDto;
import com.app.restobarpool.services.ITableService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tables")
public class TableController {

    private final ITableService tableService;

    @GetMapping("/all")
    @Tag(name = "TABLE", description = "Table methods")
    @Operation(summary = "Find all tables")
    public ResponseEntity<?> findAllTables() {
        return ResponseEntity.ok(tableService.findAllTables());
    }

    @PostMapping("/save")
    @Tag(name = "TABLE")
    @Operation(summary = "Save table")
    public ResponseEntity<?> saveTable(@RequestBody SaveTableDto saveTableDto) {
        try {
            return ResponseEntity.ok(tableService.saveTable(saveTableDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/{id}")
    @Tag(name = "TABLE", description = "Table methods")
    @Operation(summary = "Find table by ID")
    public ResponseEntity<?> findTableById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(tableService.findTableById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/{id}")
    @Tag(name = "TABLE", description = "Table methods")
    @Operation(summary = "Delete table by ID")
    public ResponseEntity<?> deleteTableById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(tableService.deleteTableById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping("/{id}")
    @Tag(name = "TABLE", description = "Table methods")
    @Operation(summary = "Update table by ID")
    public ResponseEntity<?> updateTableById(@PathVariable Long id, @RequestBody SaveTableDto saveTableDto) {
        try {
            return ResponseEntity.ok(tableService.updateById(id, saveTableDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping("/set_initial/{id}")
    @Tag(name = "TABLE")
    @Operation(summary = "Set initial time")
    public ResponseEntity<?> setInitialTime(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(tableService.setInitialTime(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping("/set_final/{id}")
    @Tag(name = "TABLE")
    @Operation(summary = "Set final time")
    public ResponseEntity<?> setFinalTime(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(tableService.setFinalTime(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
