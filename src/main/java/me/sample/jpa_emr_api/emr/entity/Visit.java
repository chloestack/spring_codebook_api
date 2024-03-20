package me.sample.jpa_emr_api.emr.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long visitId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    private LocalDateTime visitDate;

    @Column(length = 10)
    private String status;

    @Builder
    public Visit(Long visitId, Patient patient, Hospital hospital, LocalDateTime visitDate, String status) {
        this.visitId = visitId;
        this.patient = patient;
        this.hospital = hospital;
        this.visitDate = visitDate;
        this.status = status;
    }
}
