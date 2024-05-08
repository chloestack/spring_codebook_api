package me.sample.spring_codebook_api.codebook.dto;

import lombok.Builder;
import lombok.Data;
import me.sample.spring_codebook_api.codebook.entity.Visit;

import java.time.LocalDateTime;

@Data
public class VisitResponse {

    private Long visitId;
    private Long patientId;
    private Long hospitalId;
    private LocalDateTime visitDate;
    private String status;

    @Builder
    public VisitResponse(Visit visit) {
        this.visitId = visit.getVisitId();
        this.patientId = visit.getPatient().getPatientId();
        this.hospitalId = visit.getHospital().getHospitalId();
        this.visitDate = visit.getVisitDate();
        this.status = visit.getStatus();
    }

}
