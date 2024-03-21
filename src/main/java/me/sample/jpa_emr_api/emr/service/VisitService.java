package me.sample.jpa_emr_api.emr.service;

import me.sample.jpa_emr_api.emr.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;



}
