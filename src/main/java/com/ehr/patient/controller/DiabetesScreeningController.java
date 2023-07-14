package com.ehr.patient.controller;

import com.ehr.patient.domain.DiabetesScreening;
import com.ehr.patient.service.DiabetesScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/screening")
public class DiabetesScreeningController {

    @Autowired
    private DiabetesScreeningService diabetesScreeningService;

    @GetMapping(value = "/{id}")
    public Optional<DiabetesScreening> getById(@PathVariable Long id) {
        return diabetesScreeningService.getOne(id);
    }

    @GetMapping(value = "/all/{htsId}")
    public List<DiabetesScreening> getAll() {
        return diabetesScreeningService.findAll();
    }

    @PostMapping(value = "/add/{htsId}")
    @ResponseStatus(HttpStatus.CREATED)
    public DiabetesScreening saveScreening(@RequestBody DiabetesScreening diabetesScreening,Long htsId) {
        return diabetesScreeningService.saveDiabetesScreening(diabetesScreening,htsId);
    }

}
