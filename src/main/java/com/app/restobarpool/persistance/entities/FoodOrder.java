package com.app.restobarpool.persistance.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@jakarta.persistence.Table(name = "food_orders")
@ToString
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch=FetchType.EAGER)
    private List<Food> foods;
    private Double total_foods;
}
