package com.dhanu.eldercareai.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public record CreateMedicationScheduleRequest(
        @NotBlank String medicationName,
        @NotNull LocalTime scheduledTime,
        @NotBlank String dosage
) {
}
