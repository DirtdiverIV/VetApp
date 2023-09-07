package com.dirtdiveriv.VetApp.repositories;

import com.dirtdiveriv.VetApp.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
}
