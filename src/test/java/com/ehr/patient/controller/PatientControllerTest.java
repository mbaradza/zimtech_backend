package com.ehr.patient.controller;

import com.ehr.patient.domain.Patient;
import com.ehr.patient.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(PatientController.class)
class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PatientService patientService;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void getPatientById() throws Exception {
        final Long id = 1L;
        final Patient patient = new Patient(1L, "Edwin", "Moda", "3456656660");

        given(patientService.getOne(id)).willReturn(Optional.of(patient));
        this.mockMvc.perform(get("/api/patient/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is(patient.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(patient.getLastName())))
                .andExpect(jsonPath("$.idNumber", is(patient.getIdNumber())));

        final Optional<Patient> expected = patientService.getOne(id);

        assertThat(expected).isNotNull();
    }

    @Test
    void getAllPatients() throws Exception {
        List<Patient> patients = new ArrayList<>();
        patients.add(new Patient(1L, "Edwin", "Moda", "34-09090990D0"));
        patients.add(new Patient(2L, "Lumbi", "Fey", "34-0909900F0"));
        patients.add(new Patient(3L, "Taps", "Mulilo", "34-0909090D0"));
        Assertions.assertEquals(3, patients.size());
        given(patientService.findAll()).willReturn(patients);
        this.mockMvc.perform(get("/api/patient/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(patients.size())));
    }

    @Test
    void savePatient() throws Exception {
        Patient patient = new Patient(null, "Edwin", "Moda", "34-09090990D0");

        when(patientService.save(any(Patient.class))).thenReturn(patient);
        this.mockMvc.perform(post("/api/patient/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(patient)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName", is(patient.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(patient.getLastName())))
                .andExpect(jsonPath("$.idNumber", is(patient.getIdNumber())));


    }
}