package me.sample.spring_codebook_api.codebook.service;

import me.sample.spring_codebook_api.common.config.QueryDslConfig;
import me.sample.spring_codebook_api.codebook.dto.PatientRequest;
import me.sample.spring_codebook_api.codebook.dto.PatientResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
@Import(QueryDslConfig.class)
public class PatientServiceTest {

    @SpyBean
    private PatientService patientService;
    private PatientResponse patientResponse;

    @Before
    public void setUp() {
        PatientRequest pr = PatientRequest.builder()
                .hospitalId(1L)
                .genderCd("F")
                .birthday("2024-01-01")
                .name("김치찌개")
                .phone("010-3212-0333")
                .registrationNo("20240000111")
                .build();

        patientResponse = patientService.save(pr);
    }

    @Test
    public void 환자_조회() {
        PatientResponse newResponse = patientService.get(patientResponse.getPatientId());
        assertThat(newResponse).isNotNull();
        assertThat(newResponse.getBirthday()).isEqualTo("2024-01-01");
    }

    @Test
    public void 환자_정보_갱신() {
        PatientRequest pr = PatientRequest.builder()
                .patientId(patientResponse.getPatientId())
                .hospitalId(1L)
                .genderCd("F")
                .birthday("2020-01-01")
                .name("김치찌개")
                .phone("010-3212-0333")
                .registrationNo("20240000111")
                .build();

        PatientResponse newResponse = patientService.update(pr);
        assertThat(newResponse).isNotNull();
        assertThat(newResponse.getBirthday()).isEqualTo("2020-01-01");
        assertThat(newResponse.getRegistrationNo()).isEqualTo("20240000111");
    }

    @Test
    public void 환자_삭제() {
        patientService.delete(patientResponse.getPatientId());
        PatientResponse newResponse = patientService.get(patientResponse.getPatientId());
        assertThat(newResponse.getPatientId()).isNull();
    }

}
