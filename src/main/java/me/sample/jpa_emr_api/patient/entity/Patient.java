package me.sample.jpa_emr_api.patient.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    private Long hospitalId;

    @Column(length = 45)
    private String name;

    @Column(nullable = false)
    private int registrationNumber;

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(nullable = false, length = 20)
    private String phone;
}
