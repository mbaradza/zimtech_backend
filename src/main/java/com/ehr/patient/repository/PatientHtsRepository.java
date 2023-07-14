package com.ehr.patient.repository;

import com.ehr.patient.domain.PatientHts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientHtsRepository extends JpaRepository<PatientHts,Long> {

    List<PatientHts> findAllByPatientId(Long id);
}
