package com.app.restobarpool.service.interfaces;

import com.app.restobarpool.presentation.dto.foodOrder.FoodOrderDto;

import java.util.List;

public interface IFoodOrderService {

    List<FoodOrderDto> findAllFoodOrder();

    FoodOrderDto addFoodToOrder(Long idFoodOrder, Long idFood);

    FoodOrderDto generateFoodOrder();
}
