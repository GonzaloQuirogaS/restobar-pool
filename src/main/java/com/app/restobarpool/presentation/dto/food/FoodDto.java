package com.app.restobarpool.presentation.dto.food;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Double price;
}
