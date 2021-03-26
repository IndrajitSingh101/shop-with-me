package com.ienliven.payment.messaging;

import com.ienliven.payment.dto.PaymentInfo;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class PaymentEvent {
    private String correlationID;
    private PaymentInfo paymentInfo;
    private String orderID;
}
