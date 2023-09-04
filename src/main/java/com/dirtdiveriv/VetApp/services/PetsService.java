package com.dirtdiveriv.VetApp.services;

import com.dirtdiveriv.VetApp.models.Pets;
import com.dirtdiveriv.VetApp.repositories.PetsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;

@Service
public class PetsService {

    private final PetsRepository petsRepository;

    @Autowired
    public PetsService(PetsRepository petsRepository) {
        this.petsRepository = petsRepository;
    }

    public Pets getPetById(Long id) {
        return petsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pet with ID " + id + " not found."));
    }

    public List<Pets> getPetsByOwnerId(Long ownerId) {
        // Implementa la lógica para obtener todas las mascotas de un cliente por su ID
        return petsRepository.findByOwnerId(ownerId);
    }

    @Transactional
    public Pets updatePet(Long id, Pets updatedPet) {
        Pets existingPet = petsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pet with ID " + id + " not found."));
        existingPet.setName(updatedPet.getName());
        existingPet.setSpecies(updatedPet.getSpecies());
        existingPet.setBreed(updatedPet.getBreed());
        existingPet.setAge(updatedPet.getAge());
        // Actualiza otros atributos según sea necesario
        return petsRepository.save(existingPet);
    }

    @Transactional
    public void deletePet(Long id) {
        Pets pet = petsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pet with ID " + id + " not found."));
        petsRepository.delete(pet);
    }
}