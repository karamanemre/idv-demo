package com.idv.demo.entities.application;

import com.idv.demo.entities.abstracts.AuditingEntity;
import com.idv.demo.entities.CountryEntity;
import com.idv.demo.models.enums.ApplicationStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "applications")
@Inheritance(strategy = InheritanceType.JOINED)
public class ApplicationsEntity extends AuditingEntity {

    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "identity_number")
    private String identityNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_id")
    private CountryEntity country;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private ApplicationStatus status;
}
