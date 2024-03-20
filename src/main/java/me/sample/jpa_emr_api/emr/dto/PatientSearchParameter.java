package me.sample.jpa_emr_api.emr.dto;

import lombok.Getter;

/**
 * 환자 목록 검색조건
 */
@Getter
public class PatientSearchParameter {

    private String searchType;
    private String searchValue;

}
