package me.sample.jpa_emr_api.emr.repository;

import me.sample.jpa_emr_api.emr.entity.Patient;

import java.util.Optional;

public interface PatientCustomRepository {

    Optional<Patient> searchById(Long id);
    Optional<Patient> searchByRegistrationNo(String registrationNo);
    void savePatient(Patient patient);
    long updatePatient(Patient patient);

}
