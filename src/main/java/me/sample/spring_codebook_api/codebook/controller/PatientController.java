package me.sample.spring_codebook_api.codebook.controller;

import lombok.RequiredArgsConstructor;
import me.sample.spring_codebook_api.codebook.dto.PatientResponse;
import me.sample.spring_codebook_api.codebook.service.PatientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/{patientId}")
    public PatientResponse get(@PathVariable Long patientId) {
        return patientService.get(patientId);
    }

    @GetMapping("/{patientName}")
    public PatientResponse getByName(@PathVariable String patientName) {
        return patientService.getByName(patientName);
    }

//    @GetMapping("/list")
//    public List<PatientResponse> list (PatientSearchParameter parameter) {
//
//    }

}
