package com.movie.dto;

import lombok.*;
import org.hibernate.type.CurrencyType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Payment {

    private LocalDateTime paymentDate;
    private CurrencyType currencyType;
    private BigDecimal amount;

    @Override
    public String toString() {
        return "Payment{" +
                "paymentDate=" + paymentDate +
                ", currencyType=" + currencyType +
                ", amount=" + amount +
                '}';
    }
}
