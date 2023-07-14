package com.ehr.patient.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="patientdiabetes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DiabetesScreening implements Serializable  {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="patientHts", nullable=false)
    private PatientHts patientHts;

    private LocalDateTime time;

    int systolic;

    int dystolic;

    int glucose;

    int weight;

    int height;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public PatientHts getPatientHts() {
        return patientHts;
    }

    public void setPatientHts(PatientHts patientHts) {
        this.patientHts = patientHts;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getSystolic() {
        return systolic;
    }

    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }

    public int getDystolic() {
        return dystolic;
    }

    public void setDystolic(int dystolic) {
        this.dystolic = dystolic;
    }

    public int getGlucose() {
        return glucose;
    }

    public void setGlucose(int glucose) {
        this.glucose = glucose;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
