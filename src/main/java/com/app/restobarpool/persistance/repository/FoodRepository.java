package com.app.restobarpool.persistance.repository;

import com.app.restobarpool.persistance.entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
