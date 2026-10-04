package com.dhanu.eldercareai.service;

import com.dhanu.eldercareai.Entity.Elder;
import com.dhanu.eldercareai.repository.ElderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ElderService {
    private final ElderRepository elderRepository;

    public Elder createElder(Elder elder) {


            return elderRepository.save(elder);

    }
}
