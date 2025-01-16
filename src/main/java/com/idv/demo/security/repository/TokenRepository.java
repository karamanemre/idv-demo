package com.idv.demo.security.repository;

import com.idv.demo.security.entity.TokenEntity;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<TokenEntity, Integer> {

    @Query("""
                select t from token t
                join t.user u
                where u.id = :id and (t.expired = false or t.revoked = false)
            """)
    List<TokenEntity> findAllValidTokenByUserId(@Param("id") UUID id);

    Optional<TokenEntity> findByToken(@Param("token") String token);
}
