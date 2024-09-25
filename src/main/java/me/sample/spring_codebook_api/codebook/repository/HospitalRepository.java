package me.sample.spring_codebook_api.codebook.repository;

import me.sample.spring_codebook_api.codebook.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long>, HospitalCustomRepository {

    /**
     * 병원 정보 조회
     * @param aLong must not be {@literal null}.
     * @return
     */
    @Override
    Optional<Hospital> findById(Long aLong);

    /**
     * 요양기관 번호로 병원 정보 조회
     * @param organizationNo
     * @return
     */
    Optional<Hospital> findByOrganizationNo(String organizationNo);

    @Override
    List<Hospital> findAll();

    @Override
    long saveHospital(Hospital hospital);
}
