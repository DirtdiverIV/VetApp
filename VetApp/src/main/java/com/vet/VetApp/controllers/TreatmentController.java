package com.vet.VetApp.controllers;
import com.vet.VetApp.models.Treatment;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/treatments")
public class TreatmentController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/{id}")
    public Treatment getTreatmentById(@PathVariable Long id) {
        Treatment treatment = entityManager.find(Treatment.class, id);
        if (treatment == null) {
            throw new EntityNotFoundException("Treatment with ID " + id + " not found.");
        }
        return treatment;
    }

    @PostMapping
    @Transactional
    public Treatment createTreatment(@RequestBody Treatment treatment) {
        entityManager.persist(treatment);
        return treatment;
    }

    @PutMapping("/{id}")
    @Transactional
    public Treatment updateTreatment(@PathVariable Long id, @RequestBody Treatment updatedTreatment) {
        Treatment existingTreatment = entityManager.find(Treatment.class, id);
        if (existingTreatment == null) {
            throw new EntityNotFoundException("Treatment with ID " + id + " not found.");
        }
        // Actualiza los atributos según sea necesario
        entityManager.merge(existingTreatment);
        return existingTreatment;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteTreatment(@PathVariable Long id) {
        Treatment treatment = entityManager.find(Treatment.class, id);
        if (treatment == null) {
            throw an EntityNotFoundException("Treatment with ID " + id + " not found.");
        }
        entityManager.remove(treatment);
    }
}
