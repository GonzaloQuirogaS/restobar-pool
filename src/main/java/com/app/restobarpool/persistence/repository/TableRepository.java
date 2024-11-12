package com.app.restobarpool.persistence.repository;

import com.app.restobarpool.persistence.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TableRepository extends JpaRepository<Table, Long> {
}
