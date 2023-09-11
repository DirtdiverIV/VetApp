package com.dirtdiveriv.VetApp.controllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;
import com.dirtdiveriv.VetApp.models.MedicalHistory;

@RestController
@RequestMapping("/medicalhistories")
public class MedicalHistoryController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/{id}")
    public MedicalHistory getMedicalHistoryById(@PathVariable Long id) {
        MedicalHistory medicalHistory = entityManager.find(MedicalHistory.class, id);
        if (medicalHistory == null) {
            throw new EntityNotFoundException("Medical history with ID " + id + " not found.");
        }
        return medicalHistory;
    }

    @PostMapping
    @Transactional
    public MedicalHistory createMedicalHistory(@RequestBody MedicalHistory medicalHistory) {
        entityManager.persist(medicalHistory);
        return medicalHistory;
    }

    @PutMapping("/{id}")
    @Transactional
    public MedicalHistory updateMedicalHistory(@PathVariable Long id, @RequestBody MedicalHistory updatedMedicalHistory) {
        MedicalHistory existingMedicalHistory = entityManager.find(MedicalHistory.class, id);
        if (existingMedicalHistory == null) {
            throw new EntityNotFoundException("Medical history with ID " + id + " not found.");
        }
        entityManager.merge(existingMedicalHistory);
        return existingMedicalHistory;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteMedicalHistory(@PathVariable Long id) {
        MedicalHistory medicalHistory = entityManager.find(MedicalHistory.class, id);
        if (medicalHistory == null) {
            throw new EntityNotFoundException("Medical history with ID " + id + " not found.");
        }
        entityManager.remove(medicalHistory);
    }
}
