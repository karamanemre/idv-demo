package com.idv.demo.repository;

import com.idv.demo.entities.application.ApplicationsRetiredWorkerEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRetiredWorkerRepository extends JpaRepository<ApplicationsRetiredWorkerEntity, UUID> {
}
