package com.vet.VetApp.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.vet.VetApp.models.Appointment;

import java.util.List;

@Service
public class AppointmentService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Appointment createAppointment(Appointment appointment) {
        entityManager.persist(appointment);
        return appointment;
    }

    public Appointment getAppointmentById(Long id) {
        return entityManager.find(Appointment.class, id);
    }

    public List<Appointment> getAppointmentsByClientId(Long clientId) {
        // Implementa la lógica para obtener todas las citas de un cliente por su ID
    }

    public List<Appointment> getAppointmentsByPetId(Long petId) {
        // Implementa la lógica para obtener todas las citas de una mascota por su ID
    }

    @Transactional
    public Appointment updateAppointment(Appointment appointment) {
        return entityManager.merge(appointment);
    }

    @Transactional
    public void deleteAppointment(Long id) {
        Appointment appointment = entityManager.find(Appointment.class, id);
        if (appointment != null) {
            entityManager.remove(appointment);
        }
    }
}
