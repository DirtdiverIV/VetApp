package com.vet.VetApp.repositories;

import com.vet.VetApp.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    // Puedes agregar métodos personalizados de consulta aquí si es necesario
}
