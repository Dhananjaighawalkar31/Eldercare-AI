package com.dhanu.eldercareai.service;

import com.dhanu.eldercareai.Entity.DailyLog;
import com.dhanu.eldercareai.Entity.Elder;
import com.dhanu.eldercareai.Entity.MedicationLog;
import com.dhanu.eldercareai.Entity.MedicationSchedule;
import com.dhanu.eldercareai.dto.CreateDailyLogRequest;
import com.dhanu.eldercareai.exception.NotFoundException;
import com.dhanu.eldercareai.repository.DailyLogRepository;
import com.dhanu.eldercareai.repository.MedicationLogRepository;
import com.dhanu.eldercareai.repository.MedicationScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DailyLogService {
    private final DailyLogRepository dailyLogRepository;
    private final ElderService elderService;
    private final MedicationLogRepository medicationLogRepository;
    private final MedicationScheduleRepository medicationScheduleRepository;
    @Transactional
    public DailyLog createLog(Long elderId, CreateDailyLogRequest request){
        Elder elder = elderService.getElder(elderId);
        DailyLog dailyLog = new DailyLog();
        dailyLog.setElder(elder);
        dailyLog.setLogDate(request.logDate());
        dailyLog.setWakeTime(request.wakeTime());
        dailyLog.setSleepTime(request.sleepTime());
        dailyLog.setActivityCount(request.activityCount());
        dailyLog.setOutgoingCallsCount(request.outgoingCallsCount());

        DailyLog saved = dailyLogRepository.save(dailyLog);
        for(var entry : request.medicationTaken()){
            MedicationSchedule schedule = medicationScheduleRepository.findById(entry.medicationScheduleId())
                    .orElseThrow(() -> new NotFoundException(("Medication schedule not found")));
            MedicationLog medicationLog = new MedicationLog();
            medicationLog.setDailyLog(saved);
            medicationLog.setMedicationSchedule(schedule);
            medicationLog.setWasTaken(entry.wasTaken());
            medicationLogRepository.save(medicationLog);

        }
        return saved;
    }

    public List<DailyLog> getDailyLog(Long elderId,int days){
        LocalDate cutOff = LocalDate.now().minusDays(days);
        return dailyLogRepository.findByElderIdOrderByLogDateDesc(elderId)
                .stream()
                .filter(log -> !log.getLogDate().isBefore(cutOff))
                .toList();
    }
}
