package me.sample.spring_codebook_api.codebook.controller;

import me.sample.spring_codebook_api.codebook.entity.Hospital;
import me.sample.spring_codebook_api.codebook.entity.Patient;
import me.sample.spring_codebook_api.codebook.repository.HospitalRepository;
import me.sample.spring_codebook_api.codebook.repository.PatientRepository;
import me.sample.spring_codebook_api.codebook.repository.VisitRepository;
import me.sample.spring_codebook_api.codebook.service.PatientService;
import me.sample.spring_codebook_api.common.config.QueryDslConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PatientController.class)
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@Import(QueryDslConfig.class)
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private VisitRepository visitRepository;

    @MockBean
    private PatientService patientService;

    @MockBean
    private QueryDslConfig queryDslConfig;


    private String patientName = "김치찌개";

    public void setUp() {
        Hospital hospital =
                hospitalRepository.findByOrganizationNo("202401111")
                        .orElseThrow();

        patientRepository.savePatient(
                Patient.builder()
                        .birthday("2024-01-01")
                        .genderCd("F")
                        .hospital(hospital)
                        .name(patientName)
                        .phone("010-3212-0333")
                        .registrationNo("20240000111")
                        .build()
        );

    }

    @Test
    @DisplayName("이름으로 환자 조회")
    public void getByName() throws Exception {

        setUp();

        mockMvc.perform(
                        get("/api/patient/{patientName}", patientName)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }
}
