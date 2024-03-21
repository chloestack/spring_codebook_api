package me.sample.jpa_emr_api.emr.repository;

import me.sample.jpa_emr_api.emr.dto.PatientSearchParameter;
import me.sample.jpa_emr_api.emr.entity.Patient;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>, PatientCustomRepository {

    @Override
    Optional<Patient> searchById(Long id);

    @Override
    Optional<Patient> searchByRegistrationNo(String registrationNo);

    @Override
    List<Patient> searchBySearchParam(Pageable pageable, PatientSearchParameter searchParameter);

    @Override
    long savePatient(Patient patient);

    @Override
    long updatePatient(Patient patient);

    @Override
    void deletePatient(Long id);
}
