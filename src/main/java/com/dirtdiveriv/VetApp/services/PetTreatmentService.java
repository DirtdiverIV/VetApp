package com.dirtdiveriv.VetApp.services;

import com.dirtdiveriv.VetApp.models.Pets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dirtdiveriv.VetApp.models.PetTreatment;
import com.dirtdiveriv.VetApp.models.Pets;
import com.dirtdiveriv.VetApp.models.Treatment;
import com.dirtdiveriv.VetApp.repositories.PetTreatmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PetTreatmentService {

    @Autowired
    private PetTreatmentRepository petTreatmentRepository;

    @Autowired
    private PetsService petService;

    @Autowired
    private TreatmentService treatmentService;

    public PetTreatment getPetTreatmentById(Long id) {
        Optional<PetTreatment> petTreatment = petTreatmentRepository.findById(id);
        return petTreatment.orElse(null);
    }

    public List<PetTreatment> getPetTreatmentsByPetId(Long petId) {
        Pets pet = petService.getPetById(petId);
        if (pet != null) {
            return pet.getPetTreatments();
        }
        return null;
    }

    public PetTreatment createPetTreatment(PetTreatment petTreatment, Long petId, Long treatmentId) {
        Pets pet = petService.getPetById(petId);
        Treatment treatment = treatmentService.getTreatmentById(treatmentId);
        if (pet != null && treatment != null) {
            petTreatment.setPet(pet);
            petTreatment.setTreatment(treatment);
            return petTreatmentRepository.save(petTreatment);
        }
        return null;
    }

    public PetTreatment updatePetTreatment(Long id, PetTreatment updatedPetTreatment) {
        Optional<PetTreatment> existingPetTreatment = petTreatmentRepository.findById(id);
        if (existingPetTreatment.isPresent()) {
            PetTreatment petTreatment = existingPetTreatment.get();
            return petTreatmentRepository.save(petTreatment);
        }
        return null;
    }

    public void deletePetTreatment(Long id) {
        petTreatmentRepository.deleteById(id);
    }

    public PetTreatment createPetTreatment(PetTreatment petTreatment) {
        return petTreatment;
    }
}