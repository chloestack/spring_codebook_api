package me.sample.spring_codebook_api.codebook.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.sample.spring_codebook_api.codebook.entity.Hospital;
import me.sample.spring_codebook_api.codebook.entity.QHospital;
import me.sample.spring_codebook_api.codebook.repository.HospitalCustomRepository;

@RequiredArgsConstructor
public class HospitalCustomRepositoryImpl implements HospitalCustomRepository {

    private final EntityManager manager;
    private final JPAQueryFactory query;
    private static final QHospital hospital = QHospital.hospital;

    @Override
    @Transactional
    public long saveHospital(Hospital pHospital) {
        manager.persist(pHospital);
        manager.flush();
        return pHospital.getHospitalId();
    }

}
