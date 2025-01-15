package com.idv.demo.entities;

import com.idv.demo.entities.application.ApplicationsActiveWorkerEntity;
import com.idv.demo.models.enums.FamilyMemberTypes;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "family_members")
public class FamilyMembersEntity {

    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String lastname;

    @Column(name = "identity_number")
    private String identityNumber;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "family_member_type")
    private FamilyMemberTypes type;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private ApplicationsActiveWorkerEntity application;
}
