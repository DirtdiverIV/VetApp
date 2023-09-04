package com.dirtdiveriv.VetApp.controllers;

import com.dirtdiveriv.VetApp.repositories.PetsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.dirtdiveriv.VetApp.models.Pets;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetsController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PetsRepository petsRepository;

    @GetMapping("/{id}")
    public Pets getPetById(@PathVariable Long id) {
        Pets pet = entityManager.find(Pets.class, id);
        if (pet == null) {
            throw new EntityNotFoundException("Pet with ID " + id + " not found.");
        }
        return pet;
    }

    @GetMapping("/owner/{ownerId}")
    public List<Pets> getPetsByOwnerId(@PathVariable Long ownerId) {
        // Recuperar todos los Pets que pertenecen al ownerId dado
        List<Pets> pets = petsRepository.findByOwnerId(ownerId); // asumiendo que tengas un método findByOwnerId en tu repositorio PetsRepository
        if (pets.isEmpty()) {
            throw new EntityNotFoundException("No se encontraron mascotas para el cliente con ID " + ownerId);
        }
        return pets;
    }

    @PostMapping
    @Transactional
    public Pets createPet(@RequestBody Pets pet) {
        entityManager.persist(pet);
        return pet;
    }

    @PutMapping("/{id}")
    @Transactional
    public Pets updatePet(@PathVariable Long id, @RequestBody Pets updatedPet) {
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

    @DeleteMapping("/{id}")
    @Transactional
    public void deletePet(@PathVariable Long id) {
        Pets pet = entityManager.find(Pets.class, id);
        if (pet == null) {
            throw new EntityNotFoundException("Pet with ID " + id + " not found.");
        }
        entityManager.remove(pet);
    }
}