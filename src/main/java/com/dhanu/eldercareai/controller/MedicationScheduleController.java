package com.dhanu.eldercareai.controller;

import com.dhanu.eldercareai.Entity.MedicationSchedule;
import com.dhanu.eldercareai.dto.CreateMedicationScheduleRequest;
import com.dhanu.eldercareai.dto.MedicationScheduleResponse;
import com.dhanu.eldercareai.service.ElderService;
import com.dhanu.eldercareai.service.MedicationScheduleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class MedicationScheduleController {
    private final MedicationScheduleService medicationScheduleService;
    @PostMapping("/api/elders/{elderId}/medications")
    public MedicationScheduleResponse createMedication(@PathVariable Long elderId , @Valid @RequestBody CreateMedicationScheduleRequest request){
        MedicationSchedule medicationSchedule = new MedicationSchedule();
        medicationSchedule.setMedicationName(request.medicationName());
        medicationSchedule.setScheduledTime(request.scheduledTime());
        medicationSchedule.setDosage(request.dosage());
        MedicationSchedule saved = medicationScheduleService.createSchedule(elderId,medicationSchedule);
        return new MedicationScheduleResponse(
                saved.getId(),
                saved.getElder().getId(),
                saved.getMedicationName(),
                saved.getScheduledTime(),
                saved.getDosage()
        );

    }
}
