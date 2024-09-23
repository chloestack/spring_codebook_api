package me.sample.spring_codebook_api.codebook.repository;

import me.sample.spring_codebook_api.codebook.dto.PatientSearchParameter;
import me.sample.spring_codebook_api.codebook.entity.Patient;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PatientCustomRepository {

    Optional<Patient> searchById(Long id);
    Optional<Patient> searchByPatientName(String patientName);
    Optional<Patient> searchByRegistrationNo(String registrationNo);
    List<Patient> searchBySearchParam(Pageable pageable, PatientSearchParameter searchParameter);
    long savePatient(Patient patient);
    long updatePatient(Patient patient);
    void deletePatient(Long id);

}
