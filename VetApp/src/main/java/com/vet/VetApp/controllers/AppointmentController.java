package com.vet.VetApp.controllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;
import com.vet.VetApp.models.Appointment;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        Appointment appointment = entityManager.find(Appointment.class, id);
        if (appointment == null) {
            throw new EntityNotFoundException("Appointment with ID " + id + " not found.");
        }
        return appointment;
    }

    @GetMapping("/client/{clientId}")
    public List<Appointment> getAppointmentsByClientId(@PathVariable Long clientId) {
        // Implementa la lógica para obtener todas las citas de un cliente por su ID
    }

    @GetMapping("/pet/{petId}")
    public List<Appointment> getAppointmentsByPetId(@PathVariable Long petId) {
        // Implementa la lógica para obtener todas las citas de una mascota por su ID
    }

    @PostMapping
    @Transactional
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        entityManager.persist(appointment);
        return appointment;
    }

    @PutMapping("/{id}")
    @Transactional
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment updatedAppointment) {
        Appointment existingAppointment = entityManager.find(Appointment.class, id);
        if (existingAppointment == null) {
            throw new EntityNotFoundException("Appointment with ID " + id + " not found.");
        }
        existingAppointment.setDate(updatedAppointment.getDate());
        // Actualiza otros atributos según sea necesario
        entityManager.merge(existingAppointment);
        return existingAppointment;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteAppointment(@PathVariable Long id) {
        Appointment appointment = entityManager.find(Appointment.class, id);
        if (appointment == null) {
            throw new EntityNotFoundException("Appointment with ID " + id + " not found.");
        }
        entityManager.remove(appointment);
    }
}
