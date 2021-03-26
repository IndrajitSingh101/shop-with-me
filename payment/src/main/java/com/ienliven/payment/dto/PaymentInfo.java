package com.ienliven.payment.dto;

import com.ienliven.payment.enumerations.PaymentMode;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
public class PaymentInfo {
    private String account;
    private PaymentMode mode;
    private BigDecimal amount;
}
