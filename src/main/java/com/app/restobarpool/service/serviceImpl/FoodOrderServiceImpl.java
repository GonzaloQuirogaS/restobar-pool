package com.app.restobarpool.service.serviceImpl;

import com.app.restobarpool.presentation.dto.foodOrder.FoodOrderDto;
import com.app.restobarpool.util.mapper.FoodOrderMapper;
import com.app.restobarpool.persistence.entity.Food;
import com.app.restobarpool.persistence.entity.FoodOrder;
import com.app.restobarpool.persistence.repository.FoodOrderRepository;
import com.app.restobarpool.persistence.repository.FoodRepository;
import com.app.restobarpool.service.interfaces.IFoodOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodOrderServiceImpl implements IFoodOrderService {

    private final FoodOrderRepository foodOrderRepository;
    private final FoodRepository foodRepository;
    private final FoodOrderMapper mapper;

    @Override
    public List<FoodOrderDto> findAllFoodOrder() {
        List<FoodOrder> foodOrders = foodOrderRepository.findAll();
        return foodOrders.stream().map(mapper::mapToFoodOrderDto).collect(Collectors.toList());
    }

    @Override
    public FoodOrderDto addFoodToOrder(Long idFoodOrder, Long idFood) {

        //Busco el food order por id
        FoodOrder foodOrder = foodOrderRepository.findById(idFoodOrder).orElseThrow();

        //Obtengo el array de comidas  para ir agregando
        List<Food> foods = foodOrder.getFoods();

        //Si el array de foods esta vacio crea uno nuevo, caso contrario utiliza el traido desde la foodOrder
        if (foods == null) {
            foods = new ArrayList<>();
        }

        //Busco la comida por id y la agrego al arraylist
        Food food = foodRepository.findById(idFood).orElseThrow();
        foods.add(food);

        //Creo la variable sum_total y mediante .sum() voy sumando todos los precios del arraylist foods
        double sum_total = foods.stream().mapToDouble(Food::getPrice).sum();

        //Seteo el total y las comidas en foodOrder
        foodOrder.setTotal_foods(sum_total);
        foodOrder.setFoods(foods);

        foodOrderRepository.save(foodOrder);
        return mapper.mapToFoodOrderDto(foodOrder);
    }

    @Override
    public FoodOrderDto generateFoodOrder() {
        FoodOrder foodOrder = new FoodOrder();
        //Guardo la foodOrder
        foodOrderRepository.save(foodOrder);
        return mapper.mapToFoodOrderDto(foodOrder);
    }

}
