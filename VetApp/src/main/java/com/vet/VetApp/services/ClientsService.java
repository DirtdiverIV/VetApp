package com.vet.VetApp.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.vet.VetApp.models.Clients;

import java.util.List;

@Service
public class ClientsService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Clients createClient(Clients client) {
        entityManager.persist(client);
        return client;
    }

    public Clients getClientById(Long id) {
        return entityManager.find(Clients.class, id);
    }

    public List<Clients> getAllClients() {
        // Implementa la lógica para obtener todos los clientes
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
