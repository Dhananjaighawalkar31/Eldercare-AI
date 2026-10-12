package com.dhanu.eldercareai.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record ElderResponse(
        Long id,
        String name,
        LocalDate dateOfBirth,
        String address,
        LocalTime baselineWakeTime,
        LocalTime baselineSleepTime
) {
}
