package me.sample.spring_codebook_api.codebook.repository;

import me.sample.spring_codebook_api.codebook.entity.Visit;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VisitCustomRepository {

    Optional<Visit> searchById(Long id);
    void saveVisit(Visit visit);
    long updateVisit(Visit visit);

}
