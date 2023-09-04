package com.dirtdiveriv.VetApp.models;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "pets") // Especifica el nombre de la tabla en la base de datos
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
    private Clients owner;

    @OneToMany(mappedBy = "pet")
    private List<Appointment>appointments;

    @OneToMany(mappedBy = "pet")
    private List<MedicalHistory>medicalHistories;

    // Getters y setters
    // ...

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

    public List<MedicalHistory>getMedicalHistories() {
        return medicalHistories;
    }

    public void setMedicalHistories(List<MedicalHistory>medicalHistories) {
        this.medicalHistories = medicalHistories;
    }
}
