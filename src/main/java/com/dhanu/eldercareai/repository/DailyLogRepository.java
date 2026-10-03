package com.dhanu.eldercareai.repository;

import com.dhanu.eldercareai.Entity.DailyLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DailyLogRepository extends JpaRepository<DailyLog,Long> {
    List<DailyLog> findByElderIdOrderByLogDateDesc(Long elderId);
    Optional<DailyLog> findByElderIdAndLogDate(Long elderId, LocalDate logDate);
}
