package com.payment.repository;

import com.payment.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
