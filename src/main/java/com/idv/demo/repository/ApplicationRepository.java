package com.idv.demo.repository;

import com.idv.demo.entities.application.ApplicationsEntity;
import com.idv.demo.models.enums.ApplicationStatus;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationsEntity, UUID> {

    @Transactional
    @Modifying
    @Query("UPDATE applications a SET a.status = :status WHERE a.id=:id")
    void changeStatus(@Param("status") ApplicationStatus status,
                      @Param("id") UUID id);

    @Query("""
                SELECT a 
                FROM applications a 
                WHERE (:status IS NULL OR a.status = :status)
                  AND (
                    COALESCE(:search, '') = ''
                    OR LOWER(a.name) LIKE LOWER(CONCAT('%', :search, '%'))
                    OR LOWER(a.lastname) LIKE LOWER(CONCAT('%', :search, '%'))
                    OR LOWER(a.identityNumber) LIKE LOWER(CONCAT('%', :search, '%'))
                  )
                  AND a.status=:status
            """)
    List<ApplicationsEntity> findByFilters(
            @Param("status") ApplicationStatus status,
            @Param("search") String search
    );

}
