package com.dirtdiveriv.VetApp.controllers;

import com.dirtdiveriv.VetApp.services.PaymentService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.dirtdiveriv.VetApp.models.Payment;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        List<Payment> payments = paymentService.getAllPayments();
        if (payments.isEmpty()) {
            // Puedes lanzar una excepción o devolver un mensaje de error personalizado aquí si lo deseas.
            throw new EntityNotFoundException("No payments found.");
        }
        return payments;
    }

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        Payment payment = entityManager.find(Payment.class, id);
        if (payment == null) {
            throw new EntityNotFoundException("Payment with ID " + id + " not found.");
        }
        return payment;
    }

    @PostMapping
    @Transactional
    public Payment createPayment(@RequestBody Payment payment) {
        entityManager.persist(payment);
        return payment;
    }

    @PutMapping("/{id}")
    @Transactional
    public Payment updatePayment(@PathVariable Long id, @RequestBody Payment updatedPayment) {
        Payment existingPayment = entityManager.find(Payment.class, id);
        if (existingPayment == null) {
            throw new EntityNotFoundException("Payment with ID " + id + " not found.");
        }
        entityManager.merge(existingPayment);
        return existingPayment;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletePayment(@PathVariable Long id) {
        Payment payment = entityManager.find(Payment.class, id);
        if (payment == null) {
            throw new EntityNotFoundException("Payment with ID " + id + " not found.");
        }
        entityManager.remove(payment);
    }
}
