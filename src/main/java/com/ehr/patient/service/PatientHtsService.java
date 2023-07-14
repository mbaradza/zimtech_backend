package com.ehr.patient.service;

import com.ehr.patient.domain.PatientHts;

import java.util.List;

public interface PatientHtsService extends GenericService<PatientHts> {

    List<PatientHts> findByPatient(Long patientId);

    PatientHts savePatientHts(PatientHts patientHts, Long patientId);
}
