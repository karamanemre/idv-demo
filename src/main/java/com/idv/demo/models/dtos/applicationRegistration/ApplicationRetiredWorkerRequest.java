package com.idv.demo.models.dtos.applicationRegistration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.idv.demo.models.enums.ApplicationTypes;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationRetiredWorkerRequest extends ApplicationBaseRequest {

    @NotBlank(message = "validation.notnull")
    private String lastDutyTitle;

    @NotNull(message = "validation.notnull")
    private Date reasonDate;

    @NotBlank(message = "validation.notnull")
    private String reasonDesc;
}
