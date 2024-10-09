package com.app.restobarpool.controllers;

import com.app.restobarpool.services.ITableOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/table_order")
public class TableOrderController {

    private final ITableOrderService tableOrderService;

    @GetMapping("/all")
    @Tag(name = "TABLE ORDER")
    @Operation(summary = "Find all Table orders")
    public ResponseEntity<?> findAllTableOrders() {
        try {
            return ResponseEntity.ok(tableOrderService.findAllTableOrder());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PostMapping("save/{id}")
    @Tag(name = "TABLE ORDER")
    @Operation(summary = "Save Table order by ID")
    public ResponseEntity<?> saveTableOrder(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(tableOrderService.saveTableOrder(id));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }

    }

}
