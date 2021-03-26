package com.ienliven.messaging;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEvent {
    private String correlationID;
    private PaymentInfo paymentInfo;
    private String orderID;
}
