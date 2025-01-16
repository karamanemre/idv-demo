package com.idv.demo.models.dtos.applicationRegistration;

import com.idv.demo.models.enums.FamilyMemberTypes;
import com.idv.demo.utils.RegexUtil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @Pattern(regexp = RegexUtil.IDENTITY_NUMBER_REGEX, message = "validation.invalid.identityNumber")
    private String identityNumber;
}
