package com.idv.demo.models.dtos.confirmation;

import com.idv.demo.models.enums.ApplicationStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfirmationRequest {
    @NotBlank(message = "validation.notnull")
    private UUID applicationId;

    @NotNull(message = "validation.notnull")
    private ApplicationStatus status;
}
