package com.app.restobarpool.persistence.repository;

import com.app.restobarpool.persistence.entity.TableOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableOrderRepository extends JpaRepository<TableOrder, Long> {
}
