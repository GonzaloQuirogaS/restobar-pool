package com.app.restobarpool.services.servicesImpl;

import com.app.restobarpool.dto.food.FoodDto;
import com.app.restobarpool.dto.food.SaveFoodDto;
import com.app.restobarpool.mapper.FoodMapper;
import com.app.restobarpool.persistance.entities.Food;
import com.app.restobarpool.persistance.repository.FoodRepository;
import com.app.restobarpool.services.IFoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements IFoodService {

    private final FoodRepository foodRepository;
    private final FoodMapper mapper;

    @Override
    public List<FoodDto> findAllFoods() {
        List<Food> foods = foodRepository.findAll();
        return foods.stream().map(mapper::mapToFoodDto).collect(Collectors.toList());
    }

    @Override
    public FoodDto saveFood(SaveFoodDto saveFoodDto) {
        Food food = new Food();
        food.setName(saveFoodDto.getName());
        food.setPrice(saveFoodDto.getPrice());
        food.setDescription(saveFoodDto.getDescription());
        foodRepository.save(food);
        return mapper.mapToFoodDto(food);
    }

    @Override
    public FoodDto findFoodById(Long id) {
        Food food = foodRepository.findById(id).orElseThrow();
        return mapper.mapToFoodDto(food);
    }

    @Override
    public FoodDto deleteFoodById(Long id) {
        Food food = foodRepository.findById(id).orElseThrow();
        foodRepository.deleteById(id);
        return mapper.mapToFoodDto(food);
    }

    @Override
    public FoodDto updateFood(Long id, SaveFoodDto saveFoodDto) {
        Food food = foodRepository.findById(id).orElseThrow();
        food.setName(saveFoodDto.getName());
        food.setPrice(saveFoodDto.getPrice());
        food.setDescription(saveFoodDto.getDescription());
        foodRepository.save(food);
        return mapper.mapToFoodDto(food);
    }
}
