package com.ehr.patient.domain;

import com.ehr.patient.enums.HTSResult;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="patienthts")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PatientHts implements Serializable  {

    @Id
    @GeneratedValue
    private Long id;

    private Boolean onTreatment;

    @OneToOne(fetch = FetchType.LAZY)
    private Patient patient;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date  treatmentStartDate;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date  screeningDate;


    @Enumerated(EnumType.STRING)
    private HTSResult htsResult;

    @OneToOne(fetch = FetchType.LAZY)
    private DiabetesScreening diabetesScreening;

    @OneToMany(mappedBy = "patientHts")
    @Fetch(FetchMode.JOIN)
    private Set<DiabetesScreening> diabetesScreenings = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getOnTreatment() {
        return onTreatment;
    }

    public void setOnTreatment(Boolean onTreatment) {
        this.onTreatment = onTreatment;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getTreatmentStartDate() {
        return treatmentStartDate;
    }

    public void setTreatmentStartDate(Date treatmentStartDate) {
        this.treatmentStartDate = treatmentStartDate;
    }

    public Date getScreeningDate() {
        return screeningDate;
    }

    public void setScreeningDate(Date screeningDate) {
        this.screeningDate = screeningDate;
    }

    public HTSResult getHtsResult() {
        return htsResult;
    }

    public void setHtsResult(HTSResult htsResult) {
        this.htsResult = htsResult;
    }

    public DiabetesScreening getDiabetesScreening() {
        return diabetesScreening;
    }

    public void setDiabetesScreening(DiabetesScreening diabetesScreening) {
        this.diabetesScreening = diabetesScreening;
    }

    public Set<DiabetesScreening> getDiabetesScreenings() {
        return diabetesScreenings;
    }

    public void setDiabetesScreenings(Set<DiabetesScreening> diabetesScreenings) {
        this.diabetesScreenings = diabetesScreenings;
    }
}
