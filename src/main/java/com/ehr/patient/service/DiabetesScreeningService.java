package com.ehr.patient.service;

import com.ehr.patient.domain.DiabetesScreening;

import java.util.List;

public interface DiabetesScreeningService extends GenericService<DiabetesScreening> {

List<DiabetesScreening> findByHtsId(Long htsId);

DiabetesScreening saveDiabetesScreening(DiabetesScreening diabetesScreening,Long htsId);
}
