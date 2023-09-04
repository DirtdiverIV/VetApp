package com.dirtdiveriv.VetApp.repositories;
import com.dirtdiveriv.VetApp.models.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long> {
    // Este repositorio hereda métodos CRUD estándar de JpaRepository

    // Puedes agregar métodos personalizados aquí, por ejemplo, para buscar un cliente por su ID:
    Optional<Clients> findById(Long id);
}
