package com.dhanu.eldercareai.controller;

import com.dhanu.eldercareai.Entity.DailyLog;
import com.dhanu.eldercareai.dto.CreateDailyLogRequest;
import com.dhanu.eldercareai.service.DailyLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/elders/{elderId}/logs")
@RequiredArgsConstructor
public class DailyLogController {
    private final DailyLogService dailyLogService;
    @PostMapping
    public DailyLog createLog(@PathVariable Long elderId, @RequestBody CreateDailyLogRequest createDailyLogRequest){
        return dailyLogService.createLog(elderId,createDailyLogRequest);
    }
    @GetMapping
    public List<DailyLog> getRecentLogs(@PathVariable Long elderId,@RequestParam(defaultValue = "30") int days){
        return dailyLogService.getDailyLog(elderId,days);
    }

}
