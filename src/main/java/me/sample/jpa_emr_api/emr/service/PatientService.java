package me.sample.jpa_emr_api.emr.service;

import me.sample.jpa_emr_api.emr.repository.HospitalRepository;
import me.sample.jpa_emr_api.emr.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private HospitalRepository hospitalRepository;



}
