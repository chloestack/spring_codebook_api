package me.sample.jpa_emr_api.emr.repository;


import me.sample.jpa_emr_api.emr.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long>, VisitCustomRepository {

    @Override
    Optional<Visit> searchById(Long id);

    @Override
    void saveVisit(Visit visit);

    @Override
    long updateVisit(Visit visit);

}
