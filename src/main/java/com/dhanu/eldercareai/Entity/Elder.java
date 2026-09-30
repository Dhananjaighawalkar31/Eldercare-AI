package com.dhanu.eldercareai.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "elder")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Elder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private LocalTime baselineWakeTime;
    private LocalTime baselineSleepTime;
}