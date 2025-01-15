package com.idv.demo.services.application;

import com.idv.demo.entities.CountryEntity;
import com.idv.demo.models.dtos.applicationRegistration.ApplicationBaseRequest;
import com.idv.demo.models.enums.ApplicationStatus;

public interface ApplicationFactory {
    void create(ApplicationBaseRequest request, CountryEntity country);
}
