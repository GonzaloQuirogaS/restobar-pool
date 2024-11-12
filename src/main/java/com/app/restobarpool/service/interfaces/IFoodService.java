package com.app.restobarpool.service.interfaces;

import com.app.restobarpool.presentation.dto.food.FoodDto;
import com.app.restobarpool.presentation.dto.food.SaveFoodDto;

import java.util.List;

public interface IFoodService {

    List<FoodDto> findAllFoods();

    FoodDto saveFood(SaveFoodDto saveFoodDto);

    FoodDto findFoodById(Long id);

    FoodDto deleteFoodById(Long id);

    FoodDto updateFood(Long id, SaveFoodDto saveFoodDto);
}
