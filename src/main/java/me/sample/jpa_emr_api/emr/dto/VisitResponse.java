package me.sample.jpa_emr_api.emr.dto;

import lombok.Builder;
import lombok.Data;
import me.sample.jpa_emr_api.emr.entity.Patient;
import me.sample.jpa_emr_api.emr.entity.Visit;

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
