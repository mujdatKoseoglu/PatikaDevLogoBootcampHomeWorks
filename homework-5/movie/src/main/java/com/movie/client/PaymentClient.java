package com.movie.client;

import com.movie.dto.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "payment-service", url = "${payment.url}")
public interface PaymentClient {

    @PostMapping(value = "/create")
    Payment createPayment(@RequestBody Payment payment);

    @GetMapping
    Payment getPaymentById(@PathVariable Integer paymentId);

}