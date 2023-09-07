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
        return entityManager.createQuery("SELECT a FROM Appointment a WHERE a.client.id = :clientId", Appointment.class)
                .setParameter("clientId", clientId)
                .getResultList();
    }

    public List<Appointment> getAppointmentsByPetId(Long petId) {
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
