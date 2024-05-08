package me.sample.spring_codebook_api.codebook.dto;

import lombok.Data;

/**
 * 환자 목록 검색조건
 */
@Data
public class PatientSearchParameter {

    private String searchType;
    private String searchValue;

}
