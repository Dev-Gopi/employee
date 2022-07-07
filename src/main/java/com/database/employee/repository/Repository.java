package com.database.employee.repository;

import com.database.employee.entity.EntityDatabase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<EntityDatabase, Long> {
}
