package com.dirtdiveriv.VetApp.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "medical_histories")
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "id", nullable = false)
    private Pets pet;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String description;

    @ManyToOne
    @JoinColumn(name = "treatment_id", referencedColumnName = "id", nullable = false)
    private Treatment treatment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pets getPet() {
        return pet;
    }

    public void setPet(Pets pet) {
        this.pet = pet;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }
}
