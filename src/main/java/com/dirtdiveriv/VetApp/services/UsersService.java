package com.dirtdiveriv.VetApp.services;
import com.dirtdiveriv.VetApp.models.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Users createUser(Users user) {
        entityManager.persist(user);
        return user;
    }

    public Users getUserById(Long id) {
        return entityManager.find(Users.class, id);
    }

    @Transactional
    public Users updateUser(Users user) {
        return entityManager.merge(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        Users user = entityManager.find(Users.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
