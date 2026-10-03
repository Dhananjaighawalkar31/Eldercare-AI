package com.dhanu.eldercareai.repository;

import com.dhanu.eldercareai.Entity.AlertHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertHistoryRepository extends JpaRepository<AlertHistory,Long> {
    List<AlertHistory> findByElderIdOrderByTriggeredAtDesc(Long elderId);
    List<AlertHistory> findByResolvedFalse();

}
