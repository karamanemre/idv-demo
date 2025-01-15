package com.idv.demo.models.dtos.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequest {
    @NotBlank(message = "validation.notnull")
    private String email;

    @NotBlank(message = "validation.notnull")
    private String password;
}
