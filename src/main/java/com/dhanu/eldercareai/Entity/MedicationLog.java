package com.dhanu.eldercareai.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "medication_log")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicationLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "daily_log_id")
    private DailyLog dailyLog;

    @ManyToOne
    @JoinColumn(name="medication_schedule_id")

    private MedicationSchedule medicationSchedule;

    private boolean wasTaken;
}
