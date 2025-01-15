package com.idv.demo.controller;

import com.idv.demo.models.dtos.applicationRegistration.ApplicationBaseRequest;
import com.idv.demo.models.dtos.applicationRegistration.ApplicationGetResponse;
import com.idv.demo.models.enums.ApplicationStatus;
import com.idv.demo.services.application.ApplicationService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/application")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping
    public void registerApplication(@Valid @RequestBody ApplicationBaseRequest request) {
        this.applicationService.create(request);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('IK', 'ADMIN')")
    public List<ApplicationGetResponse> getApplications(@RequestParam(required = false) String search) {
        return this.applicationService.getApplications(search);
    }
}
