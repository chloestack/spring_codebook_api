package me.sample.spring_codebook_api.codebook.controller;

import me.sample.spring_codebook_api.codebook.entity.Hospital;
import me.sample.spring_codebook_api.codebook.entity.Patient;
import me.sample.spring_codebook_api.codebook.repository.HospitalRepository;
import me.sample.spring_codebook_api.codebook.repository.PatientRepository;
import me.sample.spring_codebook_api.codebook.repository.VisitRepository;
import me.sample.spring_codebook_api.codebook.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
public class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HospitalRepository hospitalRepository;

    @MockBean
    private PatientRepository patientRepository;

    @MockBean
    private VisitRepository visitRepository;

    @MockBean
    private PatientService patientService;

    private String patientName = "김치찌개";

    // @BeforeEach
    public void setup() {

        Hospital hospital1 = Hospital.builder()
                .name("홍두깨")
                .organizationNo("202401111")
                .director("한마음병원")
                .build();

        Hospital hospital2 = Hospital.builder()
                .name("아무개")
                .organizationNo("202401112")
                .director("예쁜치과")
                .build();

        Long hospitalId1 = hospitalRepository.saveHospital(hospital1);
        Long hospitalId2 = hospitalRepository.saveHospital(hospital2);

        System.out.println("--------  :: " + hospitalId1 + "," + hospitalId2);

        patientRepository.savePatient(
                Patient.builder()
                        .birthday("2024-01-01")
                        .genderCd("F")
                        .hospital(hospital1)
                        .name(patientName)
                        .phone("010-3212-0333")
                        .registrationNo("20240000111")
                        .build()
        );
    }

    @Test
    @DisplayName("이름으로 환자 조회")
    @Transactional
    public void getByName() throws Exception {
        Hospital hospital1 = Hospital.builder()
                .name("홍두깨")
                .organizationNo("202401111")
                .director("한마음병원")
                .build();
        Long hospitalId1 = hospitalRepository.saveHospital(hospital1);
        System.out.println("--------  :: " + hospitalId1);
        mockMvc.perform(
                        get("/api/patient/{patientName}", patientName)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }

}
