package com.vet.VetApp.repositories;
import com.vet.VetApp.models.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long> {
    // Este repositorio hereda métodos CRUD estándar de JpaRepository

    // Puedes agregar métodos personalizados aquí, por ejemplo, para buscar un cliente por su ID:
    Clients findById(Long id);
}
