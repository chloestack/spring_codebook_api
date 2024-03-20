package me.sample.jpa_emr_api.emr.repository;

import me.sample.jpa_emr_api.emr.entity.Visit;

import java.util.Optional;

public interface VisitCustomRepository {

    Optional<Visit> searchById(Long id);
    void saveVisit(Visit visit);
    long updateVisit(Visit visit);

}
