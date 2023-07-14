package com.ehr.patient.service.impl;

import com.ehr.patient.domain.DiabetesScreening;
import com.ehr.patient.domain.Patient;
import com.ehr.patient.domain.PatientHts;
import com.ehr.patient.repository.DiabetesScreeningRepository;
import com.ehr.patient.service.DiabetesScreeningService;
import com.ehr.patient.service.PatientHtsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DiabetesScreeningServiceImpl implements DiabetesScreeningService {

    @Autowired
    private DiabetesScreeningRepository diabetesScreeningRepository;
    @Autowired
    private PatientHtsService patientHtsService;

    @Override
    public DiabetesScreening save(DiabetesScreening daibetesScreening) {
        return diabetesScreeningRepository.save(daibetesScreening);
    }

    @Override
    public List<DiabetesScreening> findAll() {
        return diabetesScreeningRepository.findAll();
    }

    @Override
    public Optional<DiabetesScreening> getOne(Long id) {
        return diabetesScreeningRepository.findById(id);
    }

    @Override
    public List<DiabetesScreening> findByHtsId(Long htsId) {
        return diabetesScreeningRepository.findAllByPatientHtsId(htsId);
    }

    @Override
    public DiabetesScreening saveDiabetesScreening(DiabetesScreening diabetesScreening,Long htsId) {
        PatientHts patientHts = patientHtsService.getOne(htsId).orElse(null);
        if(patientHts==null){
            throw new IllegalArgumentException("Patient Hts Not Found");
        }
        else{
            diabetesScreening.setPatientHts(patientHts);
            return diabetesScreeningRepository.save(diabetesScreening);
        }

    }
}
