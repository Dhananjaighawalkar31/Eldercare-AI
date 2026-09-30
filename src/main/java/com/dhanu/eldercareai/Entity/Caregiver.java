package com.dhanu.eldercareai.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "caregiver")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Caregiver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String relationToElder;
    private String phone;
    private String email;
    private Integer escalationPriority;
}
