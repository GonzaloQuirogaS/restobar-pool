package com.app.restobarpool.services;

import com.app.restobarpool.dto.foodOrder.FoodOrderDto;

import java.util.List;

public interface IFoodOrderService {

    List<FoodOrderDto> findAllFoodOrder();

    FoodOrderDto addFoodToOrder(Long idFoodOrder, Long idFood);

    FoodOrderDto generateFoodOrder();
}
