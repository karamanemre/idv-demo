package com.idv.demo.services.application;

import com.idv.demo.entities.CountryEntity;
import com.idv.demo.entities.FamilyMembersEntity;
import com.idv.demo.entities.application.ApplicationsActiveWorkerEntity;
import com.idv.demo.models.dtos.applicationRegistration.ApplicationActiveWorkerRequest;
import com.idv.demo.models.dtos.applicationRegistration.ApplicationBaseRequest;
import com.idv.demo.models.enums.ApplicationStatus;
import com.idv.demo.repository.ApplicationActiveWorkerRepository;
import com.idv.demo.repository.FamilyMemberRepository;
import com.idv.demo.services.LogService;
import com.idv.demo.services.log.LogConsole;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("ApplicationActiveWorkerService")
@RequiredArgsConstructor
public class ApplicationActiveWorkerService extends ApplicationConverter implements ApplicationFactory {

    private final ApplicationActiveWorkerRepository repository;
    private final FamilyMemberRepository familyMemberRepository;
    private final LogService logService;

    @Override
    public void create(ApplicationBaseRequest request, CountryEntity country) {
        ApplicationActiveWorkerRequest activeWorkerRequest = (ApplicationActiveWorkerRequest) request;

        try {
            ApplicationsActiveWorkerEntity entity = this.toEntity(activeWorkerRequest, country, ApplicationStatus.PENDING);
            ApplicationsActiveWorkerEntity savedValue = this.repository.save(entity);
            List<FamilyMembersEntity> familyMembersEntities = this.getFamilyMember(activeWorkerRequest.getFamilies(), savedValue);
            this.familyMemberRepository.saveAll(familyMembersEntities);
        } catch (Exception e) {
            LogConsole.error("An error occurred while creating ApplicationActiveWorker detail: ", e.getMessage());
            this.logService.error(e, ApplicationActiveWorkerService.class);
        }
    }
}
