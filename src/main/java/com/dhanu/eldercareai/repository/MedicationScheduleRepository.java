package com.dhanu.eldercareai.repository;

import com.dhanu.eldercareai.Entity.MedicationSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicationScheduleRepository extends JpaRepository<MedicationSchedule,Long> {
    List<MedicationSchedule> findByElderId(Long elderId);
}
