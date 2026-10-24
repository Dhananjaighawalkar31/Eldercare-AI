package com.dhanu.eldercareai.controller;

import com.dhanu.eldercareai.Entity.DailyLog;
import com.dhanu.eldercareai.dto.CreateDailyLogRequest;
import com.dhanu.eldercareai.service.DailyLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/elders/{elderId}/logs")
@RequiredArgsConstructor
public class DailyLogController {
    private final DailyLogService dailyLogService;
    @PostMapping
    public DailyLog createLog(@PathVariable Long elderId, @RequestBody CreateDailyLogRequest createDailyLogRequest){
        return dailyLogService.createLog(elderId,createDailyLogRequest);
    }

}
