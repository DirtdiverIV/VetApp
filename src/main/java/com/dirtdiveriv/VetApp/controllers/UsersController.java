package com.dirtdiveriv.VetApp.controllers;
import com.dirtdiveriv.VetApp.repositories.UsersRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dirtdiveriv.VetApp.models.Users;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UsersRepository userRepository;

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable Long id) {
        Users user = entityManager.find(Users.class, id);
        if (user == null) {
            throw new EntityNotFoundException("User with ID " + id + " not found.");
        }
        return user;
    }

    @PostMapping
    @Transactional
    public Users createUser(@RequestBody Users user) {
        entityManager.persist(user);
        return user;
    }

    @PutMapping("/{id}")
    @Transactional
    public Users updateUser(@PathVariable Long id, @RequestBody Users updatedUser) {
        Users existingUser = entityManager.find(Users.class, id);
        if (existingUser == null) {
            throw new EntityNotFoundException("User with ID " + id + " not found.");
        }
        entityManager.merge(existingUser);
        return existingUser;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteUser(@PathVariable Long id) {
        Users user = entityManager.find(Users.class, id);
        if (user == null) {
            throw new EntityNotFoundException("User with ID " + id + " not found.");
        }
        entityManager.remove(user);
    }
}
