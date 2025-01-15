package com.idv.demo.models.dtos.applicationRegistration;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.idv.demo.models.enums.ApplicationTypes;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ApplicationActiveWorkerRequest.class, name = "ACTIVE_WORKER"),
        @JsonSubTypes.Type(value = ApplicationRetiredWorkerRequest.class, name = "RETIRED_WORKER")
})
public class ApplicationBaseRequest {
    @NotNull(message = "validation.notnull")
    private String name;

    @NotNull(message = "validation.notnull")
    private String lastname;

    @NotNull(message = "validation.notnull")
    @Pattern(regexp = "\\d{11}", message = "validation.invalid.identityNumber")
    private String identityNumber;

    @NotBlank(message = "validation.notnull")
    private String destinationCountryCode;

    @NotNull(message = "validation.notnull")
    private ApplicationTypes type;
}
