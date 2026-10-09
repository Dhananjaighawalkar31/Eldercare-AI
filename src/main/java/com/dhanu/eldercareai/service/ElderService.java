package com.dhanu.eldercareai.service;

import com.dhanu.eldercareai.Entity.Caregiver;
import com.dhanu.eldercareai.Entity.Elder;
import com.dhanu.eldercareai.exception.NotFoundException;
import com.dhanu.eldercareai.repository.CaregiverRepository;
import com.dhanu.eldercareai.repository.ElderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ElderService {

    private final ElderRepository elderRepository;
    private final CaregiverRepository caregiverRepository;

    public Elder createElder(Elder elder) {
        return elderRepository.save(elder);
    }

    public Elder getElder(Long id) {
        return elderRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Elder not found with id: " + id));
    }

    public List<Elder> getAllElders() {
        return elderRepository.findAll();
    }

    public Elder addCaregiverToElder(Long elderId, Long caregiverId) {
        Elder elder = getElder(elderId);

        Caregiver caregiver = caregiverRepository.findById(caregiverId)
                .orElseThrow(() ->
                        new NotFoundException("Caregiver not found with id: " + caregiverId));

        elder.getCaregivers().add(caregiver);

        return elderRepository.save(elder);
    }
}