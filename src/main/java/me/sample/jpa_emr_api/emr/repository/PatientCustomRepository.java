package me.sample.jpa_emr_api.emr.repository;

import me.sample.jpa_emr_api.emr.dto.PatientSearchParameter;
import me.sample.jpa_emr_api.emr.entity.Patient;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PatientCustomRepository {

    Optional<Patient> searchById(Long id);
    Optional<Patient> searchByRegistrationNo(String registrationNo);
    List<Patient> searchBySearchParam(Pageable pageable, PatientSearchParameter searchParameter);
    long savePatient(Patient patient);
    long updatePatient(Patient patient);
    void deletePatient(Long id);

}
