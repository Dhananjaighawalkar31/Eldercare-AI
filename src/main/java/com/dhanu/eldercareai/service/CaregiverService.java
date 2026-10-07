package com.dhanu.eldercareai.service;

import com.dhanu.eldercareai.Entity.Caregiver;
import com.dhanu.eldercareai.repository.CaregiverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CaregiverService {
    private final CaregiverRepository caregiverRepository;

    public Caregiver createCaregiver(Caregiver caregiver){
        return caregiverRepository.save(caregiver);
    }
    public Caregiver getCaregiverById(Long id){
        return caregiverRepository.findById(id).orElseThrow( () ->
            new RuntimeException("caregiver not found")
        );
    }
    public List<Caregiver> getAllCaregivers(){
        return caregiverRepository.findAll();
    }
}
