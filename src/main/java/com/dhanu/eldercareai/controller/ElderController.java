package com.dhanu.eldercareai.controller;

import com.dhanu.eldercareai.Entity.Elder;
import com.dhanu.eldercareai.service.ElderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/elders")
@RequiredArgsConstructor
public class ElderController {
    private final ElderService elderService;

    @PostMapping
    public Elder createElder(@RequestBody Elder elder){
        return elderService.createElder(elder);
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
