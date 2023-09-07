package com.dirtdiveriv.VetApp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "pets")
public class Pets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String species;

    private String breed;
    private int age;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Clients owner;

    @OneToMany(mappedBy = "pet")
    @JsonIgnore
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "pet")
    @JsonIgnore
    private List<MedicalHistory> medicalHistories;

    @OneToMany(mappedBy = "pets", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PetTreatment> petTreatments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Clients getOwner() {
        return owner;
    }

    public void setOwner(Clients owner) {
        this.owner = owner;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<MedicalHistory> getMedicalHistories() {
        return medicalHistories;
    }

    public void setMedicalHistories(List<MedicalHistory> medicalHistories) {
        this.medicalHistories = medicalHistories;
    }

    public List<PetTreatment> getPetTreatments() {
        return petTreatments;
    }

    public void setPetTreatments(List<PetTreatment> petTreatments) {
        this.petTreatments = petTreatments;
    }
}