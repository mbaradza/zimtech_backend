package com.ehr.patient.controller;

import com.ehr.patient.domain.PatientHts;
import com.ehr.patient.service.PatientHtsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hts")
public class PatientHtsController {

    @Autowired
    private PatientHtsService patientHtsService;

    @GetMapping(value = "/{id}")
    public Optional<PatientHts> getById(@PathVariable Long id) {
        return patientHtsService.getOne(id);
    }

    @GetMapping(value = "/patient/{patientId}")
    public List<PatientHts> getByPatient(@PathVariable Long patientId) {
        return patientHtsService.findByPatient(patientId);
    }

    @PostMapping(value = "/add/{patientId}")
    @ResponseStatus(HttpStatus.CREATED)
    public PatientHts save(@RequestBody PatientHts patientHts, @PathVariable Long patientId) {
        return patientHtsService.savePatientHts(patientHts,patientId);
    }

}
