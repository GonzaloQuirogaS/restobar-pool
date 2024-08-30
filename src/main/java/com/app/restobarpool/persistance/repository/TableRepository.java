package com.app.restobarpool.persistance.repository;

import com.app.restobarpool.persistance.entities.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Table, Long> {
}
