package com.vet.VetApp.repositories;

import com.vet.VetApp.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    // Puedes agregar métodos personalizados de consulta aquí si es necesario
}
