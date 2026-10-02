package com.dhanu.eldercareai.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "medication_schedule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MedicationSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "elder_id")
    private Elder elder;
    private String medicationName;
    private LocalTime scheduledTime;
    private String dosage;
}
