package com.dirtdiveriv.VetApp.services;

import com.dirtdiveriv.VetApp.repositories.PaymentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dirtdiveriv.VetApp.models.Payment;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Payment createPayment(Payment payment) {
        entityManager.persist(payment);
        return payment;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
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
