package com.app.restobarpool.presentation.dto.foodOrder;

import com.app.restobarpool.persistence.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodOrderDto implements Serializable {

    private Long id;
    private List<Food> foods;
    private Double total_foods;

}
