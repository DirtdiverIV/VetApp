package com.dirtdiveriv.VetApp.repositories;

import com.dirtdiveriv.VetApp.models.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
    // Puedes agregar métodos personalizados de consulta aquí si es necesario
}
