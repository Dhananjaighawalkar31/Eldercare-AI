package com.dhanu.eldercareai.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name="daily_log")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DailyLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="elder_id")
    private Elder elder;

    private Date logGate;
    private LocalTime wakeTime;
    private LocalTime sleepTime;
    private int activityCount;
    private int outgoingCallsCount;
}
