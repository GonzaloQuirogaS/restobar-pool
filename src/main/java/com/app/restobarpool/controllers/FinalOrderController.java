package com.app.restobarpool.controllers;


import com.app.restobarpool.dto.finalOrder.FinalOrderDto;
import com.app.restobarpool.services.IFinalOrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/final_order")
public class FinalOrderController {

    private final IFinalOrderService finalOrderService;

    @GetMapping("/all")
    @Tag(name = "FINAL ORDER", description = "Final order methods")
    @Operation(summary = "Find all final orders")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(finalOrderService.findAll());
    }

    @PostMapping("/save")
    @Tag(name = "FINAL ORDER")
    @Operation(summary = "Save Final Order receiving FoodOrder ID and TableOrder ID as a parameter")
    public ResponseEntity<?> save(@RequestParam Long idFoodOrder, @RequestParam Long idTableOrder) {

        return ResponseEntity.ok(finalOrderService.save(idFoodOrder, idTableOrder));
    }

}
