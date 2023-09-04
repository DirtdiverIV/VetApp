package com.dirtdiveriv.VetApp.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.dirtdiveriv.VetApp.models.Payment;

@Service
public class PaymentService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Payment createPayment(Payment payment) {
        entityManager.persist(payment);
        return payment;
    }

    public Payment getPaymentById(Long id) {
        return entityManager.find(Payment.class, id);
    }

    @Transactional
    public Payment updatePayment(Payment payment) {
        return entityManager.merge(payment);
    }

    @Transactional
    public void deletePayment(Long id) {
        Payment payment = entityManager.find(Payment.class, id);
        if (payment != null) {
            entityManager.remove(payment);
        }
    }
}
