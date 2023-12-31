package com.vet.VetApp.repositories;
import com.vet.VetApp.models.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {
    // Puedes agregar métodos personalizados de consulta aquí si es necesario
}
