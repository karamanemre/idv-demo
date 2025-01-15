package com.idv.demo.models.dtos.applicationRegistration;

import com.idv.demo.entities.CountryEntity;
import com.idv.demo.models.enums.ApplicationStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationGetResponse {
    private UUID id;
    private String name;
    private String lastname;
    private String identityNumber;
    private String countryId;
    private String countryName;
    private String countryCode;
    private ApplicationStatus status;
}
