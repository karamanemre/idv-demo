package com.idv.demo.repository;

import com.idv.demo.entities.LogEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<LogEntity, UUID> {
}
