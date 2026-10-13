package com.dhanu.eldercareai.controller;

import com.dhanu.eldercareai.Entity.Elder;
import com.dhanu.eldercareai.dto.CreateElderRequest;
import com.dhanu.eldercareai.dto.ElderResponse;
import com.dhanu.eldercareai.service.ElderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/elders")
@RequiredArgsConstructor
public class ElderController {
    private final ElderService elderService;
    @PostMapping
    public ElderResponse createElder(@Valid @RequestBody CreateElderRequest request) {
        Elder elder = new Elder();
        elder.setName(request.name());
        elder.setDateOfBirth(request.dateOfBirth());
        elder.setAddress(request.address());
        elder.setBaselineWakeTime(request.baselineWakeTime());
        elder.setBaselineSleepTime(request.baselineSleepTime());
        Elder saved = elderService.createElder(elder);
        return new ElderResponse(saved.getId(), saved.getName(), saved.getDateOfBirth(),
                saved.getAddress(), saved.getBaselineWakeTime(), saved.getBaselineSleepTime());

    }
    @GetMapping("/{id}")
    public Elder getElderById(@PathVariable Long id){
        return elderService.getElder(id);
    }
    @GetMapping
    public List<Elder> getAllElders(){
        return elderService.getAllElders();
    }
    @PostMapping("/{elderId}/caregivers/{caregiverId}")
    public Elder linkCaregiver(@PathVariable Long elderId,@PathVariable Long caregiverId){
        return elderService.addCaregiverToElder(elderId,caregiverId);
    }
}
