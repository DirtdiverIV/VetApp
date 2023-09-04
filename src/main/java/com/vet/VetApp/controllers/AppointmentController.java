package com.vet.VetApp.controllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;
import com.vet.VetApp.models.Appointment;
import com.vet.VetApp.services.AppointmentService;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @PersistenceContext
    private EntityManager entityManager;

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        if (appointment == null) {
            throw new EntityNotFoundException("Appointment with ID " + id + " not found.");
        }
        return appointment;
    }

    @GetMapping("/client/{clientId}")
    public List<Appointment> getAppointmentsByClientId(@PathVariable Long clientId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByClientId(clientId);
        if (appointments.isEmpty()) {
            throw new EntityNotFoundException("No appointments found for client with ID " + clientId);
        }
        return appointments;
    }

    @GetMapping("/pet/{petId}")
    public List<Appointment> getAppointmentsByPetId(@PathVariable Long petId) {
        List<Appointment> appointments = appointmentService.getAppointmentsByPetId(petId);
        if (appointments.isEmpty()) {
            throw new EntityNotFoundException("No appointments found for pet with ID " + petId);
        }
        return appointments;
    }

    @PostMapping
    @Transactional
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.createAppointment(appointment);
    }

    @PutMapping("/{id}")
    @Transactional
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment updatedAppointment) {
        Appointment existingAppointment = appointmentService.getAppointmentById(id);
        if (existingAppointment == null) {
            throw new EntityNotFoundException("Appointment with ID " + id + " not found.");
        }
        existingAppointment.setDate(updatedAppointment.getDate());
        // Actualiza otros atributos según sea necesario
        return appointmentService.updateAppointment(existingAppointment);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteAppointment(@PathVariable Long id) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        if (appointment == null) {
            throw new EntityNotFoundException("Appointment with ID " + id + " not found.");
        }
        appointmentService.deleteAppointment(id);
    }
}
