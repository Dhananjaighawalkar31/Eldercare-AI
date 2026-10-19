package com.dhanu.eldercareai.dto;

import java.time.LocalTime;

public record MedicationScheduleResponse(
        Long id,
        Long elderId,
        String medicationName,
        LocalTime scheduledTime,
        String dosage
) {
}