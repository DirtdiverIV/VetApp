package com.vet.VetApp.services;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.vet.VetApp.models.Pets;

import java.util.List;

@Service
public class PetsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Pets createPet(Pets pet) {
        entityManager.persist(pet);
        return pet;
    }

    public Pets getPetById(Long id) {
        return entityManager.find(Pets.class, id);
    }

    public List<Pets> getPetsByOwnerId(Long ownerId) {
        // Implementa la lógica para obtener todas las mascotas de un cliente por su ID
    }

    @Transactional
    public Pets updatePet(Long id, Pets updatedPet) {
        Pets existingPet = entityManager.find(Pets.class, id);
        if (existingPet == null) {
            throw new EntityNotFoundException("Pet with ID " + id + " not found.");
        }
        existingPet.setName(updatedPet.getName());
        existingPet.setSpecies(updatedPet.getSpecies());
        existingPet.setBreed(updatedPet.getBreed());
        existingPet.setAge(updatedPet.getAge());
        // Actualiza otros atributos según sea necesario
        entityManager.merge(existingPet);
        return existingPet;
    }

    @Transactional
    public void deletePet(Long id) {
        Pets pet = entityManager.find(Pets.class, id);
        if (pet == null) {
            throw new EntityNotFoundException("Pet with ID " + id + " not found.");
        }
        entityManager.remove(pet);
    }
}