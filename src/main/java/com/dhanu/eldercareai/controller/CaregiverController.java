package com.dhanu.eldercareai.controller;

import com.dhanu.eldercareai.Entity.Caregiver;
import com.dhanu.eldercareai.Entity.Elder;
import com.dhanu.eldercareai.service.CaregiverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/caregivers")
@RequiredArgsConstructor
public class CaregiverController {
    private final CaregiverService caregiverService;

    @PostMapping
    public Caregiver createCaregiver(@RequestBody Caregiver caregiver){
        return caregiverService.createCaregiver(caregiver);
    }
    @GetMapping
    public List<Caregiver> getCaregiver(){
        return caregiverService.getAllCaregivers();
    }
    @GetMapping("/{id}")
    public Caregiver getCaregiverById(@PathVariable Long id){
        return caregiverService.getCaregiverById(id);
    }

}
