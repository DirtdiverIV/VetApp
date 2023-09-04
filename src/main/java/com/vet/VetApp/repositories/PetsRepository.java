package com.vet.VetApp.repositories;

import com.vet.VetApp.models.Pets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetsRepository extends JpaRepository<Pets, Long> {
    List<Pets> findByOwnerId(Long ownerId);
}
