package com.app.restobarpool.util.mapper;

import com.app.restobarpool.presentation.dto.food.FoodDto;
import com.app.restobarpool.persistence.entity.Food;
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
