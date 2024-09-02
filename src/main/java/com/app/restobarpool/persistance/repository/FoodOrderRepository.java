package com.app.restobarpool.persistance.repository;

import com.app.restobarpool.persistance.entities.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {
}
