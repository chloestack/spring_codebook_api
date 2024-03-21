package me.sample.jpa_emr_api.emr.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.sample.jpa_emr_api.emr.entity.Patient;

/**
 * 등록된 환자 정보
 */
@Data
@NoArgsConstructor
public class PatientResponse {

    private Long patientId;
    private Long hospitalId;
    private String name;
    private String registrationNo;
    private String genderCd;
    private String birthday;
    private String phone;

    @Builder
    public PatientResponse(Patient patient) {
        this.patientId = patient.getPatientId();
        this.hospitalId = patient.getHospital() == null ?
                null : patient.getHospital().getHospitalId();
        this.name = patient.getName();
        this.registrationNo = patient.getRegistrationNo();
        this.genderCd = patient.getGenderCd();
        this.birthday = patient.getBirthday();
        this.phone = patient.getPhone();
    }

}
