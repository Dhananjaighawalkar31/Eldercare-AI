package com.dhanu.eldercareai.controller;

import com.dhanu.eldercareai.Entity.Caregiver;
import com.dhanu.eldercareai.dto.CaregiverResponse;
import com.dhanu.eldercareai.dto.CreateCaregiverRequest;
import com.dhanu.eldercareai.service.CaregiverService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/caregivers")
@RequiredArgsConstructor
public class CaregiverController {
    private final CaregiverService caregiverService;

    @PostMapping
    public CaregiverResponse createCaregiver(@Valid @RequestBody CreateCaregiverRequest createCaregiverRequest){
        Caregiver caregiver = new Caregiver();
        caregiver.setName(createCaregiverRequest.name());
        caregiver.setEmail(createCaregiverRequest.email());
        caregiver.setPhone(createCaregiverRequest.phone());
        caregiver.setEscalationPriority(createCaregiverRequest.escalationPriority());
        caregiver.setRelationToElder(createCaregiverRequest.relationToElder());
        Caregiver saved =  caregiverService.createCaregiver(caregiver);
        return new CaregiverResponse(saved.getId(), saved.getName(), saved.getRelationToElder(),saved.getPhone(),saved.getEmail(), saved.getEscalationPriority());
    }
    @GetMapping
    public List<CaregiverResponse> getCaregiver(){
        List<CaregiverResponse> result = new ArrayList<>();
        List<Caregiver> caregivers = caregiverService.getAllCaregivers();
        for(Caregiver caregiver : caregivers){
            result.add(new CaregiverResponse(caregiver.getId(),caregiver.getName(), caregiver.getRelationToElder(), caregiver.getPhone(), caregiver.getEmail(), caregiver.getEscalationPriority()));
        }
        return result;
    }
    @GetMapping("/{id}")
    public CaregiverResponse getCaregiverById(@PathVariable Long id){

        Caregiver caregiver =  caregiverService.getCaregiverById(id);
        return new CaregiverResponse(caregiver.getId(),caregiver.getName(), caregiver.getRelationToElder(), caregiver.getPhone(), caregiver.getEmail(), caregiver.getEscalationPriority());
    }

}
