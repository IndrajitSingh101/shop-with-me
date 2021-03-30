package com.ienliven.payment.messaging;

import com.ienliven.payment.dto.PaymentInfo;
import lombok.*;

@Data
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEvent {
    private String correlationID;
    private PaymentInfo paymentInfo;
    private String orderID;
}
