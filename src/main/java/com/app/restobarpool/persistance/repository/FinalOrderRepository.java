package com.app.restobarpool.persistance.repository;

import com.app.restobarpool.persistance.entities.FinalOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinalOrderRepository extends JpaRepository<FinalOrder, Long> {
}
