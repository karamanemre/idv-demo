package com.idv.demo.services.application;

import com.idv.demo.entities.application.ApplicationsEntity;
import com.idv.demo.entities.CountryEntity;
import com.idv.demo.exception.BadRequestException;
import com.idv.demo.mapper.ApplicationMapper;
import com.idv.demo.models.dtos.applicationRegistration.ApplicationBaseRequest;
import com.idv.demo.models.dtos.applicationRegistration.ApplicationGetResponse;
import com.idv.demo.models.enums.ApplicationStatus;
import com.idv.demo.models.enums.ApplicationTypes;
import com.idv.demo.repository.ApplicationRepository;
import com.idv.demo.services.CountryService;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final CountryService countryService;
    private final Map<String, ApplicationFactory> instances;
    private final ApplicationMapper applicationMapper;

    public void create(ApplicationBaseRequest request) {
        CountryEntity country = countryService.getCountryByCode(request.getDestinationCountryCode());
        this.getInstance(request.getType()).create(request, country);
    }

    public void changeStatus(UUID id, ApplicationStatus status) {
        this.applicationRepository.changeStatus(status, id);
    }

    public ApplicationsEntity findById(UUID id) {
        return this.applicationRepository.findById(id).orElse(null);
    }

    public List<ApplicationGetResponse> getApplications(String search) {
        List<ApplicationsEntity> entities = this.applicationRepository.findByFilters(ApplicationStatus.PENDING, search);
        return this.applicationMapper.toDto(entities);
    }

    private ApplicationFactory getInstance(ApplicationTypes type) {
        ApplicationFactory instance = instances.get(type.getValue());
        if (instance == null) {
            throw new BadRequestException("Unsupported type");
        }
        return instance;
    }
}
