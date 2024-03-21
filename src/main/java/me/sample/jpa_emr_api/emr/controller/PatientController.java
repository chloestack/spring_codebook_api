package me.sample.jpa_emr_api.emr.controller;

import lombok.RequiredArgsConstructor;
import me.sample.jpa_emr_api.emr.dto.PatientResponse;
import me.sample.jpa_emr_api.emr.dto.PatientSearchParameter;
import me.sample.jpa_emr_api.emr.service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/{patientId}")
    public PatientResponse get(@PathVariable Long patientId) {
        return patientService.get(patientId);
    }

//    @GetMapping("/list")
//    public List<PatientResponse> list (PatientSearchParameter parameter) {
//
//    }

}
