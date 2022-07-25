package com.payment.model;

import lombok.*;
import org.hibernate.type.CurrencyType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private LocalDateTime paymentDate;
    private CurrencyType currencyType;
    private BigDecimal amount;
}
