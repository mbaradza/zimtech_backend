package com.ehr.patient.controller;

import com.ehr.patient.domain.Patient;
import com.ehr.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping(value = "/{id}")
    public Optional<Patient> getPatientById(@PathVariable Long id) {
        return patientService.getOne(id);
    }

    @GetMapping(value = "/all")
    public List<Patient> getAllPatients() {
        return patientService.findAll();
    }

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient savePatient(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

}
