package com.app.restobarpool.services.servicesImpl;

import com.app.restobarpool.dto.foodOrder.FoodOrderDto;
import com.app.restobarpool.mapper.FoodOrderMapper;
import com.app.restobarpool.persistance.entities.Food;
import com.app.restobarpool.persistance.entities.FoodOrder;
import com.app.restobarpool.persistance.repository.FoodOrderRepository;
import com.app.restobarpool.persistance.repository.FoodRepository;
import com.app.restobarpool.services.IFoodOrderService;
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

    //Creo un arraylist de comidas de forma global para ir agregando
    List<Food> foods = new ArrayList<>();

    //Creo un foodOrder de forma global para operar sobre el
    FoodOrder foodOrder = new FoodOrder();

    @Override
    public List<FoodOrderDto> findAllFoodOrder() {
        List<FoodOrder> foodOrders = foodOrderRepository.findAll();
        return foodOrders.stream().map(mapper::mapToFoodOrderDto).collect(Collectors.toList());
    }

    @Override
    public FoodOrderDto addFoodToOrder(Long id) {

        //Busco la comida por id y la agrego al arraylist
        Food food = foodRepository.findById(id).orElseThrow();
        foods.add(food);

        //Creo la variable sum_total y mediante .sum() voy sumando todos los precios del arraylist foods
        double sum_total;
        sum_total = foods.stream().mapToDouble(Food::getPrice).sum();

        //Seteo el total y las comidas en foodOrder
        foodOrder.setTotal_foods(sum_total);
        foodOrder.setFoods(foods);

        return mapper.mapToFoodOrderDto(foodOrder);
    }

    @Override
    public FoodOrderDto saveFoodOrder() {

        //Guardo la foodOrder
        foodOrderRepository.save(foodOrder);

        //Copio foodOrder en la variable foodOrder1 para devolverla como respuesta
        FoodOrder foodOrder1 = new FoodOrder(foodOrder.getId(), new ArrayList<>(foodOrder.getFoods()), foodOrder.getTotal_foods());

        //Reseteo foodOrder y foods para seguir operando de ser necesario
        foodOrder = new FoodOrder();
        foods.clear();
        return mapper.mapToFoodOrderDto(foodOrder1);
    }

}
