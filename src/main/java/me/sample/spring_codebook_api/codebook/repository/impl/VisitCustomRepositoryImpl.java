package me.sample.spring_codebook_api.codebook.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.sample.spring_codebook_api.codebook.entity.QVisit;
import me.sample.spring_codebook_api.codebook.entity.Visit;
import me.sample.spring_codebook_api.codebook.repository.VisitCustomRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class VisitCustomRepositoryImpl implements VisitCustomRepository {

    private final EntityManager manager;
    private final JPAQueryFactory query;
    private static final QVisit visit = QVisit.visit;



    @Override
    public Optional<Visit> searchById(Long id) {
        return Optional.ofNullable(
                query.selectFrom(visit)
                        .where(visit.visitId.eq(id))
                        .fetchOne());
    }

    @Override
    @Transactional
    public void saveVisit(Visit pVisit) {
        manager.persist(pVisit);
    }

    @Override
    @Transactional
    public long updateVisit(Visit pVisit) {
        return query.update(visit)
                .where(visit.visitId.eq(pVisit.getVisitId()))
                .set(visit.patient, pVisit.getPatient())
                .set(visit.hospital, pVisit.getHospital())
                .set(visit.visitDate, pVisit.getVisitDate())
                .set(visit.status, pVisit.getStatus())
                .execute();
    }

}
