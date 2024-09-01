package com.app.restobarpool.controllers;

import com.app.restobarpool.services.ITableOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/table_order")
public class TableOrderController {

    private final ITableOrderService tableOrderService;

    @GetMapping("/all")
    public ResponseEntity<?> findAllTableOrders() {
        try {
            return ResponseEntity.ok(tableOrderService.findAllTableOrder());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PostMapping("save/{id}")
    public ResponseEntity<?> saveTableOrder(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(tableOrderService.saveTableOrder(id));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }

    }

}
