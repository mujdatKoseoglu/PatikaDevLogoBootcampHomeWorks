package com.payment.controller;

import com.payment.model.Payment;
import com.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping(value = "/create")
    Payment createPayment(@RequestBody Payment payment){
        return paymentService.createPayment(payment);
    }

    @GetMapping
    Payment getPaymentById(@PathVariable Integer paymentId){
        return paymentService.getPaymentById(paymentId);
    }
}
