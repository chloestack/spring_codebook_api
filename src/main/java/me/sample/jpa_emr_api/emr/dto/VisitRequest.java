package me.sample.jpa_emr_api.emr.dto;


import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import me.sample.jpa_emr_api.emr.entity.Hospital;
import me.sample.jpa_emr_api.emr.entity.Patient;
import me.sample.jpa_emr_api.emr.entity.Visit;

import java.time.LocalDateTime;

/**
 * 방문 정보 등록 요청
 */
@Getter
@NoArgsConstructor
public class VisitRequest {

    private Long visitId;
    @NotNull
    private Long patientId;
    @NotNull
    private Long hospitalId;

    private LocalDateTime visitDate;

    @NotNull
    @Size(max = 10)
    private String status;

    @Builder
    public VisitRequest(Long visitId, Long patientId, Long hospitalId, LocalDateTime visitDate, String status) {
        this.visitId = visitId;
        this.patientId = patientId;
        this.hospitalId = hospitalId;
        this.visitDate = visitDate;
        this.status = status;
    }

    public Visit toEntity(Hospital hospital, Patient patient) {
        return Visit.builder()
                .visitId(visitId)
                .patient(patient)
                .hospital(hospital)
                .visitDate(visitDate)
                .status(status)
                .build();
    }
}
