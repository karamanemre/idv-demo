package com.idv.demo.services.application;

import com.idv.demo.entities.CountryEntity;
import com.idv.demo.entities.application.ApplicationsRetiredWorkerEntity;
import com.idv.demo.mapper.ApplicationMapper;
import com.idv.demo.models.dtos.applicationRegistration.ApplicationBaseRequest;
import com.idv.demo.models.dtos.applicationRegistration.ApplicationRetiredWorkerRequest;
import com.idv.demo.models.enums.ApplicationStatus;
import com.idv.demo.repository.ApplicationRetiredWorkerRepository;
import com.idv.demo.services.LogService;
import com.idv.demo.services.log.LogConsole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("ApplicationRetiredWorkerService")
@RequiredArgsConstructor
public class ApplicationRetiredWorkerService implements ApplicationFactory {

    private final ApplicationMapper mapper;
    private final ApplicationRetiredWorkerRepository repository;
    private final LogService logService;

    @Override
    public void create(ApplicationBaseRequest request, CountryEntity country) {
        try {
            final ApplicationRetiredWorkerRequest retiredWorkerRequest = (ApplicationRetiredWorkerRequest) request;
            this.saveDb(retiredWorkerRequest, country);
        } catch (Exception e) {
            LogConsole.error("An error occurred while creating applicationRetired detail: ", e.getMessage());
            this.logService.error(e, ApplicationActiveWorkerService.class);
        }
    }

    private ApplicationsRetiredWorkerEntity saveDb(ApplicationRetiredWorkerRequest request, CountryEntity country) {
        final ApplicationsRetiredWorkerEntity entity = this.mapper.toEntity(request);
        entity.setCountry(country);
        entity.setStatus(ApplicationStatus.PENDING);
        return this.repository.save(entity);
    }
}
