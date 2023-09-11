package com.dirtdiveriv.VetApp.repositories;
import com.dirtdiveriv.VetApp.models.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long> {
    Optional<Clients> findById(Long id);
}
