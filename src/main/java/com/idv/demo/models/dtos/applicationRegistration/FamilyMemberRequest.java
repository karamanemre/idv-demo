package com.idv.demo.models.dtos.applicationRegistration;

import com.idv.demo.models.enums.FamilyMemberTypes;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FamilyMemberRequest {

    @NotNull(message = "validation.notnull")
    private FamilyMemberTypes type;

    @NotBlank(message = "validation.notnull")
    private String name;

    @NotBlank(message = "validation.notnull")
    private String lastname;

    @NotBlank(message = "validation.notnull")
    private String identityNumber;
}
