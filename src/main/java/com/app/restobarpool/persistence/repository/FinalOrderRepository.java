package com.app.restobarpool.persistence.repository;

import com.app.restobarpool.persistence.entity.FinalOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinalOrderRepository extends JpaRepository<FinalOrder, Long> {
}
