package com.idv.demo.services.application;

import com.idv.demo.entities.CountryEntity;
import com.idv.demo.entities.FamilyMembersEntity;
import com.idv.demo.entities.application.ApplicationsActiveWorkerEntity;
import com.idv.demo.mapper.ApplicationMapper;
import com.idv.demo.models.dtos.applicationRegistration.ApplicationActiveWorkerRequest;
import com.idv.demo.models.dtos.applicationRegistration.ApplicationBaseRequest;
import com.idv.demo.models.dtos.applicationRegistration.FamilyMemberRequest;
import com.idv.demo.models.enums.ApplicationStatus;
import com.idv.demo.repository.ApplicationActiveWorkerRepository;
import com.idv.demo.repository.FamilyMemberRepository;
import com.idv.demo.services.LogService;
import com.idv.demo.services.log.LogConsole;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("ApplicationActiveWorkerService")
@RequiredArgsConstructor
public class ApplicationActiveWorkerService implements ApplicationFactory {

    private final ApplicationMapper mapper;
    private final ApplicationActiveWorkerRepository repository;
    private final FamilyMemberRepository familyMemberRepository;
    private final LogService logService;

    @Override
    public void create(ApplicationBaseRequest request, CountryEntity country) {
        ApplicationActiveWorkerRequest activeWorkerRequest = (ApplicationActiveWorkerRequest) request;

        try {
            ApplicationsActiveWorkerEntity savedValue = this.saveDb(activeWorkerRequest, country);
            List<FamilyMembersEntity> familyMembersEntities = this.getFamilyMember(activeWorkerRequest.getFamilies(), savedValue);
            this.familyMemberRepository.saveAll(familyMembersEntities);
        } catch (Exception e) {
            LogConsole.error("An error occurred while creating ApplicationActiveWorker detail: ", e.getMessage());
            this.logService.error(e, ApplicationActiveWorkerService.class);
        }
    }

    private ApplicationsActiveWorkerEntity saveDb(ApplicationActiveWorkerRequest request, CountryEntity country) {
        ApplicationsActiveWorkerEntity entity = this.mapper.toEntity(request);
        entity.setCountry(country);
        entity.setStatus(ApplicationStatus.PENDING);
        return this.repository.save(entity);
    }

    private List<FamilyMembersEntity> getFamilyMember(List<FamilyMemberRequest> familyMembers, ApplicationsActiveWorkerEntity applications) {
        if (familyMembers == null) {
            return Arrays.asList();
        }

        return familyMembers
                .stream()
                .map(familyMember -> FamilyMembersEntity.builder()
                        .application(applications)
                        .familyMemberType(familyMember.getType())
                        .name(familyMember.getName())
                        .lastname(familyMember.getLastname())
                        .identityNumber(familyMember.getIdentityNumber())
                        .build())
                .collect(Collectors.toList());
    }
}
