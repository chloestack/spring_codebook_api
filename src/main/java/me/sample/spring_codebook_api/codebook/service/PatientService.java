package me.sample.spring_codebook_api.codebook.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.sample.spring_codebook_api.codebook.dto.PatientRequest;
import me.sample.spring_codebook_api.codebook.dto.PatientResponse;
import me.sample.spring_codebook_api.codebook.dto.PatientSearchParameter;
import me.sample.spring_codebook_api.codebook.entity.Hospital;
import me.sample.spring_codebook_api.codebook.entity.Patient;
import me.sample.spring_codebook_api.codebook.repository.HospitalRepository;
import me.sample.spring_codebook_api.codebook.repository.PatientRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final HospitalRepository hospitalRepository;

    public PatientResponse get(Long patientId) {
        Patient patient = patientRepository.searchById(patientId)
                .orElse(Patient.builder().build());
        return PatientResponse.builder().patient(patient).build();
    }

    public List<PatientResponse> list(Pageable pageable, PatientSearchParameter parameter) {
        List<Patient> patientList = patientRepository.searchBySearchParam(pageable, parameter);
        return patientList.stream().map(p -> PatientResponse.builder().patient(p).build()).collect(Collectors.toList());
    }

    public PatientResponse save(PatientRequest patientRequest) {

        Hospital hospital = hospitalRepository
                .findById(patientRequest.getHospitalId())
                .orElseThrow();

        long patientId = patientRepository.savePatient(patientRequest.toEntity(hospital));
        Patient patient = patientRepository.searchById(patientId)
                .orElseThrow();
        return PatientResponse.builder().patient(patient).build();
    }

    public PatientResponse update(PatientRequest patientRequest) {

        Hospital hospital = hospitalRepository
                .findById(patientRequest.getHospitalId())
                .orElseThrow();

        long patientId = patientRepository.updatePatient(patientRequest.toEntity(hospital));
        Patient patient = patientRepository.searchById(patientId)
                .orElseThrow();
        return PatientResponse.builder().patient(patient).build();
    }

    public void delete(Long patientId) {
        patientRepository.deletePatient(patientId);
    }


}
