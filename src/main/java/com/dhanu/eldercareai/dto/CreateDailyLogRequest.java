package com.dhanu.eldercareai.dto;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record CreateDailyLogRequest(
        LocalDate logDate,
        LocalTime wakeTime,
        LocalTime sleepTime,
        Integer activityCount,
        Integer outgoingCallsCount,
        List<MedicationTakenEntry> medicationTaken
) {
    public record MedicationTakenEntry(
            Long medicationScheduleId,
            Boolean wasTaken
    ){

    }
}
