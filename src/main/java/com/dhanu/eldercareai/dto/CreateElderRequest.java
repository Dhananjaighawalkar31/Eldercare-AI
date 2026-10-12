package com.dhanu.eldercareai.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalTime;

public record CreateElderRequest(
        @NotBlank String name,
        String address,
        LocalTime baselineWakeTime,
        LocalTime baselineSleepTime
) {
}
