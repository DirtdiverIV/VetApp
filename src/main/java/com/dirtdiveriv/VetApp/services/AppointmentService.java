package com.dirtdiveriv.VetApp.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.dirtdiveriv.VetApp.models.Appointment;

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
        // Por ejemplo, si tienes una relación en tu entidad Appointment con Client,
        // puedes hacer una consulta JPQL para obtener las citas del cliente por su ID.
        // Aquí un ejemplo:
        return entityManager.createQuery("SELECT a FROM Appointment a WHERE a.client.id = :clientId", Appointment.class)
                .setParameter("clientId", clientId)
                .getResultList();
    }

    public List<Appointment> getAppointmentsByPetId(Long petId) {
        // Implementa la lógica para obtener todas las citas de una mascota por su ID
        // Similar al método anterior, puedes usar una consulta JPQL para obtener las citas
        // de una mascota por su ID.
        // Aquí un ejemplo:
        return entityManager.createQuery("SELECT a FROM Appointment a WHERE a.pet.id = :petId", Appointment.class)
                .setParameter("petId", petId)
                .getResultList();
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
