package com.vet.VetApp.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.vet.VetApp.models.Treatment;

@Service
public class TreatmentService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Treatment createTreatment(Treatment treatment) {
        entityManager.persist(treatment);
        return treatment;
    }

    public Treatment getTreatmentById(Long id) {
        return entityManager.find(Treatment.class, id);
    }

    @Transactional
    public Treatment updateTreatment(Treatment treatment) {
        return entityManager.merge(treatment);
    }

    @Transactional
    public void deleteTreatment(Long id) {
        Treatment treatment = entityManager.find(Treatment.class, id);
        if (treatment != null) {
            entityManager.remove(treatment);
        }
    }
}
