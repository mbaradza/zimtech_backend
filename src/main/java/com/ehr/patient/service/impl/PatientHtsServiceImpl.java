package com.ehr.patient.service.impl;

import com.ehr.patient.domain.Patient;
import com.ehr.patient.domain.PatientHts;
import com.ehr.patient.repository.PatientHtsRepository;
import com.ehr.patient.service.PatientHtsService;
import com.ehr.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientHtsServiceImpl implements PatientHtsService {

    @Autowired
    private PatientHtsRepository patientHtsRepository;
    @Autowired
    private PatientService patientService;

    @Override
    public PatientHts save(PatientHts patientHts) {
        return patientHtsRepository.save(patientHts);
    }

    @Override
    public List<PatientHts> findAll() {
        return patientHtsRepository.findAll();
    }

    @Override
    public Optional<PatientHts> getOne(Long id) {
        return patientHtsRepository.findById(id);
    }

    @Override
    public List<PatientHts> findByPatient(Long patientId) {
        return patientHtsRepository.findAllByPatientId(patientId);
    }

    @Override
    public PatientHts savePatientHts(PatientHts patientHts, Long patientId) {

        Patient patient = patientService.getOne(patientId).orElse(null);
        if(patient==null){
            throw new IllegalArgumentException("Patient Not Fount");
        }
        else{
            patientHts.setPatient(patient);
            return  patientHtsRepository.save(patientHts);
        }
    }
}
