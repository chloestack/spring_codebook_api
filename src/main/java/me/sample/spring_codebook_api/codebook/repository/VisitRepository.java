package me.sample.spring_codebook_api.codebook.repository;


import me.sample.spring_codebook_api.codebook.entity.Visit;
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
