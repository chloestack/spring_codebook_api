package me.sample.spring_codebook_api.codebook.repository;

import me.sample.spring_codebook_api.codebook.entity.Hospital;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalCustomRepository {

    long saveHospital(Hospital hospital);

}
