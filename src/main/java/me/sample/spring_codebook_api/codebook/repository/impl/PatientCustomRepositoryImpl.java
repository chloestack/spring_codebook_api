package me.sample.spring_codebook_api.codebook.repository.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.sample.spring_codebook_api.codebook.dto.PatientSearchParameter;
import me.sample.spring_codebook_api.codebook.entity.Patient;
import me.sample.spring_codebook_api.codebook.entity.QPatient;
import me.sample.spring_codebook_api.codebook.repository.PatientCustomRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
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
    public List<Patient> searchBySearchParam(Pageable pageable, PatientSearchParameter searchParameter) {
        return query.selectFrom(patient)
                .where(eqName(searchParameter), eqRegistrationNo(searchParameter), eqBirthDay(searchParameter))
                .offset(pageable.getOffset())   // 페이지 번호
                .limit(pageable.getPageSize())  // 페이지 사이즈
                .fetch();
    }

    private BooleanExpression eqName(PatientSearchParameter param) {
        if(param == null || !"name".equals(param.getSearchType())) {
            return null;
        } else if (param.getSearchValue() == null || param.getSearchValue().isBlank()) {
            return null;
        }

        return patient.name.eq(param.getSearchValue());
    }

    private BooleanExpression eqRegistrationNo(PatientSearchParameter param) {
        if(param == null || !"registrationNo".equals(param.getSearchType())) {
            return null;
        } else if (param.getSearchValue() == null || param.getSearchValue().isBlank()) {
            return null;
        }

        return patient.registrationNo.eq(param.getSearchValue());
    }

    private BooleanExpression eqBirthDay(PatientSearchParameter param) {
        if(param == null || !"birthday".equals(param.getSearchType())) {
            return null;
        } else if (param.getSearchValue() == null || param.getSearchValue().isBlank()) {
            return null;
        }

        return patient.birthday.eq(param.getSearchValue());
    }

    @Override
    @Transactional
    public long savePatient(Patient pPatient) {
        manager.persist(pPatient);
        manager.flush();
        return pPatient.getPatientId();
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

    @Override
    @Transactional
    public void deletePatient(Long id) {
        query.delete(patient)
                .where(patient.patientId.eq(id))
                .execute();
    }


}
