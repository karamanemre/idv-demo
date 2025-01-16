package com.idv.demo.services.application;

import com.idv.demo.entities.CountryEntity;
import com.idv.demo.entities.FamilyMembersEntity;
import com.idv.demo.entities.application.ApplicationsActiveWorkerEntity;
import com.idv.demo.entities.application.ApplicationsEntity;
import com.idv.demo.entities.application.ApplicationsRetiredWorkerEntity;
import com.idv.demo.models.dtos.applicationRegistration.ApplicationActiveWorkerRequest;
import com.idv.demo.models.dtos.applicationRegistration.ApplicationGetResponse;
import com.idv.demo.models.dtos.applicationRegistration.ApplicationRetiredWorkerRequest;
import com.idv.demo.models.dtos.applicationRegistration.FamilyMemberRequest;
import com.idv.demo.models.enums.ApplicationStatus;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ApplicationConverter {

    protected ApplicationsRetiredWorkerEntity toEntity(ApplicationRetiredWorkerRequest request, CountryEntity country, ApplicationStatus status) {
        ApplicationsRetiredWorkerEntity entity = new ApplicationsRetiredWorkerEntity();
        entity.setCountry(country);
        entity.setStatus(status);
        entity.setLastname(request.getLastname());
        entity.setName(request.getName());
        entity.setIdentityNumber(request.getIdentityNumber());
        entity.setLastDutyTitle(request.getLastDutyTitle());
        entity.setReasonDate(request.getReasonDate());
        entity.setReasonDesc(request.getReasonDesc());
        return entity;
    }

    protected List<ApplicationGetResponse> toResponse(List<ApplicationsEntity> entities) {
        return entities
                .stream()
                .map(item -> {
                    ApplicationGetResponse response = new ApplicationGetResponse();
                    response.setId(item.getId());
                    response.setName(item.getCountry().getCode());
                    response.setLastname(item.getLastname());
                    response.setIdentityNumber(item.getIdentityNumber());
                    response.setCountryCode(item.getCountry().getCode());
                    response.setCountryId(item.getCountry().getId());
                    response.setCountryName(item.getCountry().getName());
                    response.setStatus(item.getStatus());
                    return response;

                })
                .collect(Collectors.toList());
    }

    protected ApplicationsActiveWorkerEntity toEntity(ApplicationActiveWorkerRequest request, CountryEntity country, ApplicationStatus status) {
        ApplicationsActiveWorkerEntity entity = new ApplicationsActiveWorkerEntity();
        entity.setCountry(country);
        entity.setStatus(status);
        entity.setDutyTitle(request.getDutyTitle());
        entity.setDutyEndDate(request.getDutyEndDate());
        entity.setDutyStartDate(request.getDutyStartDate());
        entity.setLastname(request.getLastname());
        entity.setName(request.getName());
        entity.setIdentityNumber(request.getIdentityNumber());
        return entity;
    }

    protected List<FamilyMembersEntity> getFamilyMember(List<FamilyMemberRequest> familyMembers, ApplicationsActiveWorkerEntity applications) {
        if (familyMembers == null) {
            return Arrays.asList();
        }

        return familyMembers
                .stream()
                .map(familyMember -> FamilyMembersEntity.builder()
                        .application(applications)
                        .type(familyMember.getType())
                        .name(familyMember.getName())
                        .lastname(familyMember.getLastname())
                        .identityNumber(familyMember.getIdentityNumber())
                        .build())
                .collect(Collectors.toList());
    }
}
