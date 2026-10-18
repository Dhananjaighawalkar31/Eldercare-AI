package com.dhanu.eldercareai.service;

import com.dhanu.eldercareai.Entity.MedicationSchedule;
import com.dhanu.eldercareai.exception.NotFoundException;
import com.dhanu.eldercareai.repository.ElderRepository;
import com.dhanu.eldercareai.repository.MedicationScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicationScheduleService {
    private final ElderRepository elderRepository;
    private final MedicationScheduleRepository medicationScheduleRepository;
    public MedicationSchedule createSchedule(Long elderId, MedicationSchedule medicationSchedule){
        medicationSchedule.setElder(elderRepository.findById(elderId).orElseThrow(() ->
                new NotFoundException("Elder not found with id: " + elderId)));
        return medicationScheduleRepository.save(medicationSchedule);

    }
    public List<MedicationSchedule> getSchedulesForElder(Long elderId){

        elderRepository.findById(elderId)
                .orElseThrow(() ->
                        new NotFoundException("Elder not found with id: " + elderId));
        return medicationScheduleRepository.findByElderId(elderId);

    }

}
