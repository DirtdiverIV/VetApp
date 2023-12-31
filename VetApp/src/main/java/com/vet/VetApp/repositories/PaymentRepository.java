package com.vet.VetApp.repositories;

import com.vet.VetApp.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Puedes agregar métodos personalizados de consulta aquí si es necesario
}
