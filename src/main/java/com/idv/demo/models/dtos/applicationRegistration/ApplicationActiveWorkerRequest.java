package com.idv.demo.models.dtos.applicationRegistration;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.idv.demo.utils.DateUtil;
import jakarta.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationActiveWorkerRequest extends ApplicationBaseRequest {

    @NotNull(message = "validation.notnull")
    private String registrationNumber;

    @NotNull(message = "validation.notnull")
    private String dutyTitle;

    @NotNull(message = "validation.notnull")
    private Date dutyStartDate;

    @NotNull(message = "validation.notnull")

    private Date dutyEndDate;

    @NotNull(message = "validation.notnull")
    private List<FamilyMemberRequest> families;
}
