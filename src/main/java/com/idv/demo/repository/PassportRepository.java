package com.idv.demo.repository;

import com.idv.demo.entities.passport.PassportEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends JpaRepository<PassportEntity, UUID> {
}
