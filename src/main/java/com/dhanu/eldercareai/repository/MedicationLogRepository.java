package com.dhanu.eldercareai.repository;

import com.dhanu.eldercareai.Entity.MedicationLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicationLogRepository extends JpaRepository<MedicationLog,Long> {
    List<MedicationLog> findByDailyLogId(Long dailyLogId);
}
