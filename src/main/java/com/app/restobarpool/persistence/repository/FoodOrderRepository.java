package com.app.restobarpool.persistence.repository;

import com.app.restobarpool.persistence.entity.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {
}
