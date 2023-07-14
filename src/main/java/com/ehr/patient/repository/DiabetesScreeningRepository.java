package com.ehr.patient.repository;

import com.ehr.patient.domain.DiabetesScreening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiabetesScreeningRepository extends JpaRepository<DiabetesScreening,Long> {

    List<DiabetesScreening>  findAllByPatientHtsId(Long id);
}
