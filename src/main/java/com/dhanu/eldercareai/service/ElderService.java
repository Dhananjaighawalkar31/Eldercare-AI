package com.dhanu.eldercareai.service;

import com.dhanu.eldercareai.Entity.Elder;
import com.dhanu.eldercareai.repository.ElderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ElderService {
    private final ElderRepository elderRepository;

    public Elder createElder(Elder elder) {
        return elderRepository.save(elder);
    }
    public Elder getElder(Long id){

            return elderRepository.findById(id)
                    .orElseThrow( () -> new RuntimeException("Elder not found with id: " + id));

    }
    public List<Elder> getAllElders(){
        return elderRepository.findAll();
    }
}
