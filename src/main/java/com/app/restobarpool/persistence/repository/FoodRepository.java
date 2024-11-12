package com.app.restobarpool.persistence.repository;

import com.app.restobarpool.persistence.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
}
