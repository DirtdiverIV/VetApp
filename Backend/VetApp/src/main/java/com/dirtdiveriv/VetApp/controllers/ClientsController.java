package com.dirtdiveriv.VetApp.controllers;

import com.dirtdiveriv.VetApp.repositories.ClientsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.dirtdiveriv.VetApp.models.Clients;
import com.dirtdiveriv.VetApp.models.Pets;
import com.dirtdiveriv.VetApp.models.Payment;
import com.dirtdiveriv.VetApp.services.ClientsService;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientsController {



    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ClientsRepository clientsRepository;

    @Autowired
    private final ClientsService clientsService;

    @Autowired
    public ClientsController(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    @GetMapping
    public List<Clients> getAllClients() {
        List<Clients> clients = clientsService.getAllClients();
        if (clients.isEmpty()) {
            throw new EntityNotFoundException("No clients found.");
        }
        return clients;
    }

    @GetMapping("/{id}")
    public Clients getClientById(@PathVariable Long id) {
        Clients client = clientsService.getClientById(id);
        if (client == null) {
            throw new EntityNotFoundException("Client with ID " + id + " not found.");
        }
        return client;
    }

    @GetMapping("/{id}/pets")
    public List<Pets> getClientPets(@PathVariable Long id) {
        Clients client = clientsService.getClientById(id);
        if (client == null) {
            throw new EntityNotFoundException("Client with ID " + id + " not found.");
        }

        List<Pets> pets = client.getPets();
        return pets;
    }

    @GetMapping("/{id}/payments")
    public List<Payment> getClientPayments(@PathVariable Long id) {
        Clients client = clientsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client with ID " + id + " not found."));

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
        existingClient.setMail(updatedClient.getMail());
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
