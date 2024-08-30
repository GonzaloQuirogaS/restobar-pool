package com.app.restobarpool.controllers;

import com.app.restobarpool.dto.food.SaveFoodDto;
import com.app.restobarpool.services.IFoodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/foods")
public class FoodController {

    private final IFoodService foodService;

    @GetMapping("/all")
    @Tag(name = "FOOD", description = "Food methods")
    @Operation(summary = "Find all foods")
    public ResponseEntity<?> findAllFoods() {
        return ResponseEntity.ok(foodService.findAllFoods());
    }

    @PostMapping("/save")
    @Tag(name = "FOOD")
    @Operation(summary = "Save foods")
    public ResponseEntity<?> saveFood(@RequestBody SaveFoodDto saveFoodDto) {
        try {
            return ResponseEntity.ok(foodService.saveFood(saveFoodDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @GetMapping("/{id}")
    @Tag(name = "FOOD", description = "Food methods")
    @Operation(summary = "Find food by ID")
    public ResponseEntity<?> findFoodById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(foodService.findFoodById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @DeleteMapping("/{id}")
    @Tag(name = "FOOD", description = "Food methods")
    @Operation(summary = "Delete food by ID")
    public ResponseEntity<?> deleteFoodById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(foodService.deleteFoodById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    @PutMapping("/{id}")
    @Tag(name = "FOOD", description = "Food methods")
    @Operation(summary = "Update food by ID")
    public ResponseEntity<?> updateFood(@PathVariable Long id, @RequestBody SaveFoodDto saveFoodDto) {
        try {
            return ResponseEntity.ok(foodService.updateFood(id,saveFoodDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
