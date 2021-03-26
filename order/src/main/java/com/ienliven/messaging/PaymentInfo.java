package com.ienliven.messaging;

import com.ienliven.payment.enumerations.PaymentMode;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@Builder
public class PaymentInfo {
    private String account;
    private PaymentMode mode;
    private BigDecimal amount;
}
