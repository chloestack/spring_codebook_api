package me.sample.spring_codebook_api.codebook.service;

import me.sample.spring_codebook_api.codebook.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;



}
