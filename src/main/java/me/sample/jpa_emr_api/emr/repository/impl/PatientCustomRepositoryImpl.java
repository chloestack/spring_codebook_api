package me.sample.jpa_emr_api.emr.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.sample.jpa_emr_api.emr.entity.Patient;
import me.sample.jpa_emr_api.emr.entity.QPatient;
import me.sample.jpa_emr_api.emr.repository.PatientCustomRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class PatientCustomRepositoryImpl implements PatientCustomRepository {

    private final EntityManager manager;
    private final JPAQueryFactory query;
    private static final QPatient patient = QPatient.patient;

    @Override
    public Optional<Patient> searchById(Long id) {
        return Optional.ofNullable(
                query.selectFrom(patient)
                .where(patient.patientId.eq(id))
                .fetchOne());
    }

    @Override
    public Optional<Patient> searchByRegistrationNo(String registrationNo){
        return Optional.ofNullable(
                query.selectFrom(patient)
                        .where(patient.registrationNo.eq(registrationNo))
                        .fetchOne());
    }

    @Override
    @Transactional
    public void savePatient(Patient pPatient) {
        manager.persist(pPatient);
    }

    @Override
    @Transactional
    public long updatePatient(Patient pPatient) {
        return query.update(patient)
                .where(patient.patientId.eq(pPatient.getPatientId()))
                .set(patient.name, pPatient.getName())
                .set(patient.birthday, pPatient.getBirthday())
                .set(patient.phone, pPatient.getPhone())
                .set(patient.genderCd, pPatient.getGenderCd())
                .execute();
    }
}
