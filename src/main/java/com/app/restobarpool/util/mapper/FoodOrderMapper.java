package com.app.restobarpool.util.mapper;

import com.app.restobarpool.presentation.dto.foodOrder.FoodOrderDto;
import com.app.restobarpool.persistence.entity.FoodOrder;
import org.springframework.stereotype.Service;

@Service
public class FoodOrderMapper {

    public FoodOrderDto mapToFoodOrderDto(FoodOrder foodOrder) {
        if (foodOrder == null) return null;

        FoodOrderDto foodOrderDto = new FoodOrderDto();
        foodOrderDto.setId(foodOrder.getId());
        foodOrderDto.setFoods(foodOrder.getFoods());
        foodOrderDto.setTotal_foods(foodOrder.getTotal_foods());

        return foodOrderDto;
    }
}
