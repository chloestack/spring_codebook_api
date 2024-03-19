package me.sample.jpa_emr_api.emr.entity;

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

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospitalId;

    @Column(length = 45)
    private String name;

    @Column(length = 13)
    private int registrationNo;

    @Column(length = 10)
    private String genderCd;

    @Column(nullable = false, length = 10)
    private String birthday;

    @Column(nullable = false, length = 20)
    private String phone;
}
