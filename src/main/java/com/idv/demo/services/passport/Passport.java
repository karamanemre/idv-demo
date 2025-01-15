package com.idv.demo.services.passport;

import com.idv.demo.entities.application.ApplicationsEntity;

public interface Passport {
    void process(ApplicationsEntity application);
}
