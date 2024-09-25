package me.sample.spring_codebook_api.codebook.repository;

import me.sample.spring_codebook_api.codebook.entity.Hospital;
import me.sample.spring_codebook_api.common.config.QueryDslConfig;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
@Import(QueryDslConfig.class)
class HospitalRepositoryTest {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Before
    void setUp() {


    }

    @Test
    void 병원목록조회() {

        setUp();

        List<Hospital> hospitals =
                hospitalRepository.findAll();

        assertThat(hospitals).isNotNull();
        assertThat(hospitals.size()).isEqualTo(2);
    }
//
//    @Test
//    void 환자정보등록() {
//
//        setUp();
//
//        Patient patient = patientRepository.searchByRegistrationNo("20240000111")
//                .orElseThrow();
//
//        assertThat(patient).isNotNull();
//        assertThat(patient.getPatientId()).isGreaterThan(0);
//    }
//
//    @Test
//    void 환자정보수정() {
//
//        setUp();
//
//        Patient patient = patientRepository.searchByRegistrationNo("20240000111")
//                .orElseThrow();
//
//        PatientRequest request = PatientRequest.builder()
//                .patientId(patient.getPatientId())
//                .birthday("2020-12-01")
//                .name(patient.getName())
//                .genderCd(patient.getGenderCd())
//                .phone(patient.getPhone())
//                .hospitalId(patient.getHospital().getHospitalId())
//                .build();
//
//        Hospital hospital =
//                hospitalRepository.findById(request.getHospitalId())
//                        .orElseThrow();
//
//        patientRepository.updatePatient(request.toEntity(hospital));
//
//        Patient savedPatient = patientRepository.searchById(request.getPatientId())
//                .orElseThrow();
//
//        assertThat(savedPatient).isNotNull();
//        assertThat(savedPatient.getBirthday()).isEqualTo("2020-12-01");
//
//    }

}