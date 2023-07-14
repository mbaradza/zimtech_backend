package com.ehr.patient.service.impl;

import com.ehr.patient.domain.Patient;
import com.ehr.patient.repository.PatientRepository;
import com.ehr.patient.service.PatientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PatientServiceImplTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService = new PatientServiceImpl();


    @Test
    void save() {

        final Patient patient = new Patient(null, "Morris","Baradza","3477788-7F");

        given(patientRepository.save(patient)).willAnswer(invocation -> invocation.getArgument(0));

        Patient savedPatient = patientService.save(patient);

        assertThat(savedPatient).isNotNull();

        verify(patientRepository).save(any(Patient.class));

    }

    @Test
    void findAll() {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(1L, "Edwin", "Cast", "34-09090990D0"));
        patients.add(new Patient(2L, "Lumbi", "Fey", "34-0909900F0"));
        patients.add(new Patient(3L, "Taps", "Mulilo", "34-0909090D0"));

        given(patientRepository.findAll()).willReturn(patients);

        List<Patient> expected = patientRepository.findAll();

        assertEquals(expected, patients);
    }

    @Test
    void getOne() {

        final Long id = 1L;
        final Patient patient = new Patient(1L, "Edwin", "Dasj", "3456656660");

        given(patientRepository.findById(id)).willReturn(Optional.of(patient));

        final Optional<Patient> expected  = patientService.getOne(id);
        assertThat(expected).isNotNull();
    }
}