package com.app.restobarpool.persistance.repository;

import com.app.restobarpool.persistance.entities.TableOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableOrderRepository extends JpaRepository<TableOrder, Long> {
}
