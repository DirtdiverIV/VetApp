package com.vet.VetApp.controllers;

import com.vet.VetApp.repositories.ClientsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.vet.VetApp.models.Clients;
import com.vet.VetApp.models.Pets;
import com.vet.VetApp.models.Payment;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientsController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ClientsRepository clientsRepository;

    @GetMapping("/{id}")
    public Clients getClientById(@PathVariable Long id) {
        Clients client = entityManager.find(Clients.class, id);
        if (client == null) {
            throw new EntityNotFoundException("Client with ID " + id + " not found.");
        }
        return client;
    }

    @GetMapping("/{id}/pets")
    public List<Pets> getClientPets(@PathVariable Long id) {
        // Implementa la lógica para obtener todas las mascotas de un cliente por su ID
    }

    @GetMapping("/{id}/payments")
    public List<Payment> getClientPayments(@PathVariable Long id) {
        // Recupera el cliente por su ID
        Clients client = clientsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client with ID " + id + " not found."));

        // Obtiene los pagos asociados al cliente
        List<Payment> payments = client.getPayments();

        return payments;
    }

    @PostMapping
    @Transactional
    public Clients createClient(@RequestBody Clients client) {
        entityManager.persist(client);
        return client;
    }

    @PutMapping("/{id}")
    @Transactional
    public Clients updateClient(@PathVariable Long id, @RequestBody Clients updatedClient) {
        Clients existingClient = entityManager.find(Clients.class, id);
        if (existingClient == null) {
            throw new EntityNotFoundException("Client with ID " + id + " not found.");
        }
        existingClient.setName(updatedClient.getName());
        existingClient.setEmail(updatedClient.getEmail());
        // Actualiza otros atributos según sea necesario
        entityManager.merge(existingClient);
        return existingClient;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteClient(@PathVariable Long id) {
        Clients client = entityManager.find(Clients.class, id);
        if (client == null) {
            throw new EntityNotFoundException("Client with ID " + id + " not found.");
        }
        entityManager.remove(client);
    }
}
