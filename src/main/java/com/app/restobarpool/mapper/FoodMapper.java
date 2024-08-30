package com.app.restobarpool.mapper;

import com.app.restobarpool.dto.food.FoodDto;
import com.app.restobarpool.persistance.entities.Food;
import org.springframework.stereotype.Service;

@Service
public class FoodMapper {

    public FoodDto mapToFoodDto(Food food) {
        if (food == null) return null;
        FoodDto foodDto = new FoodDto();
        foodDto.setId(food.getId());
        foodDto.setName(food.getName());
        foodDto.setPrice(food.getPrice());
        foodDto.setDescription(food.getDescription());

        return foodDto;
    }
}
