package com.dirtdiveriv.VetApp.services;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.dirtdiveriv.VetApp.models.MedicalHistory;

@Service
public class MedicalHistoryService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public MedicalHistory createMedicalHistory(MedicalHistory medicalHistory) {
        entityManager.persist(medicalHistory);
        return medicalHistory;
    }

    public MedicalHistory getMedicalHistoryById(Long id) {
        return entityManager.find(MedicalHistory.class, id);
    }

    @Transactional
    public MedicalHistory updateMedicalHistory(MedicalHistory medicalHistory) {
        return entityManager.merge(medicalHistory);
    }

    @Transactional
    public void deleteMedicalHistory(Long id) {
        MedicalHistory medicalHistory = entityManager.find(MedicalHistory.class, id);
        if (medicalHistory != null) {
            entityManager.remove(medicalHistory);
        }
    }
}
