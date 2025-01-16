package com.idv.demo.controller;

import com.idv.demo.models.dtos.applicationRegistration.ApplicationGetResponse;
import com.idv.demo.models.dtos.confirmation.ConfirmationRequest;
import com.idv.demo.models.enums.PassportStatus;
import com.idv.demo.services.ConfirmationService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/confirmation")
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('IK', 'ADMIN')")
public class ConfirmationController {

    private final ConfirmationService confirmationService;

    @PostMapping("/application")
    @Operation(
            summary = "Application Approval",
            description = "The applications go through HR evaluation. This service updates the status of the record evaluated by HR, such as PENDING, ACCEPTED, or REJECTION."
    )
    public void setApplicationStatus(@RequestBody ConfirmationRequest request) {
        this.confirmationService.setApplicationStatus(request);
    }

    @GetMapping("/waiting-passport")
    @Operation(
            summary = "Pending Passport Processes",
            description = "Approved records become part of the process of determining whether a passport will be issued. This service lists the data that has been approved by HR."
    )
    public List<ApplicationGetResponse> getWaitingPassport(@RequestParam(required = false) String search) {
        return this.confirmationService.getWaitingPassport(search);
    }

    @PutMapping("/passport/{documentId}/{status}")
    @Operation(
            summary = "CHange Passport Status",
            description = "It updates the passport status for records approved by HR, indicating whether the passport has been received or not (e.g., OK, NON_OK)"
    )
    public void updatePassportStatus(@PathVariable String documentId, PassportStatus status) {
        this.confirmationService.updatePassportStatus(documentId, status);
    }
}
