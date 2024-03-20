package me.sample.jpa_emr_api.emr.repository;

import me.sample.jpa_emr_api.emr.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

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
}
