package com.dirtdiveriv.VetApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dirtdiveriv.VetApp.models.PetTreatment;

public interface PetTreatmentRepository extends JpaRepository<PetTreatment, Long> {
}
