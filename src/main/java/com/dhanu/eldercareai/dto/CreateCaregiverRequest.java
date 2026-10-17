package com.dhanu.eldercareai.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateCaregiverRequest(
        @NotBlank String name,
        @NotBlank String relationToElder,
        String phone,
        @NotBlank @Email String email,
        Integer escalationPriority
) {

}
