package me.sample.jpa_emr_api.emr.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import me.sample.jpa_emr_api.common.config.QueryDslConfig;
import me.sample.jpa_emr_api.emr.dto.PatientRequest;
import me.sample.jpa_emr_api.emr.dto.PatientResponse;
import me.sample.jpa_emr_api.emr.dto.PatientSearchParameter;
import me.sample.jpa_emr_api.emr.entity.Hospital;
import me.sample.jpa_emr_api.emr.entity.Patient;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
@Import(QueryDslConfig.class)
class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Before
    void setUp() {
        Hospital hospital =
                hospitalRepository.findByOrganizationNo("202401111")
                        .orElseThrow();

        patientRepository.savePatient(
                Patient.builder()
                        .birthday("2024-01-01")
                        .genderCd("F")
                        .hospital(hospital)
                        .name("김치찌개")
                        .phone("010-3212-0333")
                        .registrationNo("20240000111")
                        .build()
        );

    }

    @Test
    void 환자목록조회() {
        PatientSearchParameter parameter = new PatientSearchParameter();
        parameter.setSearchType("name");
        parameter.setSearchValue("김치찌개");

        Pageable pageable = Pageable.ofSize(10);
        List<Patient> patientList =
                patientRepository.searchBySearchParam(pageable, parameter);

        assertThat(patientList).isNotNull();
        assertThat(patientList.size()).isEqualTo(1);
        // assertThat(patientList.get(0).getName()).isEqualTo("김치찌개");
    }

    @Test
    void 환자정보등록() {

        setUp();

        Patient patient = patientRepository.searchByRegistrationNo("20240000111")
                .orElseThrow();

        assertThat(patient).isNotNull();
        assertThat(patient.getPatientId()).isGreaterThan(0);
    }

    @Test
    void 환자정보수정() {

        setUp();

        Patient patient = patientRepository.searchByRegistrationNo("20240000111")
                .orElseThrow();

        PatientRequest request = PatientRequest.builder()
                .patientId(patient.getPatientId())
                .birthday("2020-12-01")
                .name(patient.getName())
                .genderCd(patient.getGenderCd())
                .phone(patient.getPhone())
                .hospitalId(patient.getHospital().getHospitalId())
                .build();

        Hospital hospital =
                hospitalRepository.findById(request.getHospitalId())
                        .orElseThrow();

        patientRepository.updatePatient(request.toEntity(hospital));

        Patient savedPatient = patientRepository.searchById(request.getPatientId())
                .orElseThrow();

        assertThat(savedPatient).isNotNull();
        assertThat(savedPatient.getBirthday()).isEqualTo("2020-12-01");

    }

}