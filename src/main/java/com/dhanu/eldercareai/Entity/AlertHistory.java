package com.dhanu.eldercareai.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "alert_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlertHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="elder_id")
    private Elder elder;

    private LocalDateTime triggeredAt;
    @Enumerated(EnumType.STRING)
    private Severity severity;

    @Enumerated(EnumType.STRING)
    private AlertSource source;
    private String explanation;
    private boolean resolved;
    private LocalDateTime resolvedAt;
}
