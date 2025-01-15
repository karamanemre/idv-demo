package com.idv.demo.controller;

import com.idv.demo.models.dtos.confirmation.ConfirmationRequest;
import com.idv.demo.models.enums.ApplicationStatus;
import com.idv.demo.models.enums.PassportStatus;
import com.idv.demo.services.ConfirmationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/confirmation")
@RequiredArgsConstructor
public class ConfirmationController {

    private final ConfirmationService confirmationService;

    @PostMapping("/ik")
    public void setApplicationStatus(@RequestBody ConfirmationRequest request) {
        this.confirmationService.setApplicationStatus(request);
    }

    @PutMapping("/{documentId}/{status}")
    public void updatePassportStatus(@PathVariable String documentId, PassportStatus status) {
        this.confirmationService.updatePassportStatus(documentId, status);
    }
}
