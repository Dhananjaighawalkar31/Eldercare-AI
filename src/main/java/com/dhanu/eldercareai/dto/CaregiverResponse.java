package com.dhanu.eldercareai.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CaregiverResponse(
        Long id,
        String name,
        String relationToElder,
        String phone,
        String email,
        Integer escalationPriority
) {
}
