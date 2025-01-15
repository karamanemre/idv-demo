package com.idv.demo.repository;

import com.idv.demo.entities.CountryEntity;
import com.idv.demo.entities.FamilyMembersEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyMemberRepository extends JpaRepository<FamilyMembersEntity, UUID> {

}
