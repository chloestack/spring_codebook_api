package me.sample.jpa_emr_api.emr.dto;

import lombok.Data;

/**
 * 등록된 환자 정보
 */
@Data
public class PatientResponse {

    private Long patientId;
    private Long hospitalId;
    private String name;
    private int registrationNo;
    private String genderCd;
    private String birthday;
    private String phone;

}
