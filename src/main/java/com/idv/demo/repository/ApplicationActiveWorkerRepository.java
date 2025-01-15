package com.idv.demo.repository;

import com.idv.demo.entities.application.ApplicationsActiveWorkerEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationActiveWorkerRepository extends JpaRepository<ApplicationsActiveWorkerEntity, UUID> {

}
