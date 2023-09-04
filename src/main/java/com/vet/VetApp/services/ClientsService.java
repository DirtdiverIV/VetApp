package com.vet.VetApp.services;

import com.vet.VetApp.repositories.ClientsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vet.VetApp.models.Clients;

import java.util.List;

@Service
public class ClientsService {
    private final ClientsRepository clientsRepository;

    @Autowired
    public ClientsService(ClientsRepository clientsRepository) {
        this.clientsRepository = clientsRepository;
    }

    @PersistenceContext
    private static EntityManager entityManager;

    @Transactional
    public Clients createClient(Clients client) {
        entityManager.persist(client);
        return client;
    }



    public static Clients getClientById(Long id) {
        return entityManager.find(Clients.class, id);
    }

    public List<Clients> getAllClients() {
        return clientsRepository.findAll();
    }

    @Transactional
    public Clients updateClient(Clients client) {
        return entityManager.merge(client);
    }

    @Transactional
    public void deleteClient(Long id) {
        Clients client = entityManager.find(Clients.class, id);
        if (client != null) {
            entityManager.remove(client);
        }
    }
}
