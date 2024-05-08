package me.sample.spring_codebook_api.codebook.dto;


import jakarta.validation.constraints.*;
import lombok.*;
import me.sample.spring_codebook_api.codebook.entity.Hospital;
import me.sample.spring_codebook_api.codebook.entity.Patient;

/**
 * 환자 정보 등록 요청
 */
@Getter
@NoArgsConstructor
public class PatientRequest {

    private Long patientId;

    @NotBlank
    private Long hospitalId;

    @NotBlank
    @Size(max=45)
    private String name;

    @NotBlank
    @Size(max = 13)
    private String registrationNo;

    @Size(max = 10)
    private String genderCd;

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "생년월일이 양식(yyyy-mm-dd)에 맞지 않습니다.")
    @Size(max = 10)
    private String birthday;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호가 양식에 맞지 않습니다.")
    @Size(max = 20)
    private String phone;

    @Builder
    public PatientRequest(Long patientId, Long hospitalId, String name, String registrationNo, String genderCd, String birthday, String phone) {
        this.patientId = patientId;
        this.hospitalId = hospitalId;
        this.name = name;
        this.registrationNo = registrationNo;
        this.genderCd = genderCd;
        this.birthday = birthday;
        this.phone = phone;
    }

    public Patient toEntity(Hospital hospital) {
        return Patient.builder()
                .patientId(patientId)
                .hospital(hospital)
                .name(name)
                .registrationNo(registrationNo)
                .genderCd(genderCd)
                .birthday(birthday)
                .phone(phone)
                .build();

    }
}
