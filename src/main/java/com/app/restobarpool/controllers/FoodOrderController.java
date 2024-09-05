package com.app.restobarpool.controllers;

import com.app.restobarpool.services.IFoodOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/food_orders")
public class FoodOrderController {

    private final IFoodOrderService foodOrderService;

    @GetMapping("/all")
    @Tag(name = "FOOD ORDER", description = "Food order methods")
    @Operation(summary = "Find all food orders")
    private ResponseEntity<?> findALlFoodOrder() {
        return ResponseEntity.ok(foodOrderService.findAllFoodOrder());
    }

    @PostMapping("/add/{id}")
    @Tag(name = "FOOD ORDER")
    @Operation(summary = "Add food in food orders by id, receiving the id of foodOrder by parameter and the id of food by body ")
    private ResponseEntity<?> addFoodInOrder(@PathVariable Long id, @RequestBody Long idFood) {
        try {
            return ResponseEntity.ok(foodOrderService.addFoodToOrder(id, idFood));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PostMapping("/save")
    @Tag(name = "FOOD ORDER")
    @Operation(summary = "Generate food order")
    private ResponseEntity<?> generateFoodOrder() {
        return ResponseEntity.ok(foodOrderService.generateFoodOrder());
    }

}
