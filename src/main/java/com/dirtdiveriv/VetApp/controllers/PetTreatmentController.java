package com.dirtdiveriv.VetApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.dirtdiveriv.VetApp.models.PetTreatment;
import com.dirtdiveriv.VetApp.services.PetTreatmentService;

import java.util.List;

@RestController
@RequestMapping("/pettreatments")
public class PetTreatmentController {

    @Autowired
    private PetTreatmentService petTreatmentService;

    @GetMapping("/{id}")
    public PetTreatment getPetTreatmentById(@PathVariable Long id) {
        return petTreatmentService.getPetTreatmentById(id);
    }

    @GetMapping("/pet/{petId}")
    public List<PetTreatment> getPetTreatmentsByPetId(@PathVariable Long petId) {
        return petTreatmentService.getPetTreatmentsByPetId(petId);
    }

    @PostMapping
    public PetTreatment createPetTreatment(@RequestBody PetTreatment petTreatment) {
        return petTreatmentService.createPetTreatment(petTreatment);
    }

    @PutMapping("/{id}")
    public PetTreatment updatePetTreatment(@PathVariable Long id, @RequestBody PetTreatment updatedPetTreatment) {
        return petTreatmentService.updatePetTreatment(id, updatedPetTreatment);
    }

    @DeleteMapping("/{id}")
    public void deletePetTreatment(@PathVariable Long id) {
        petTreatmentService.deletePetTreatment(id);
    }
}
