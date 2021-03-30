package com.ienliven.messaging;

import lombok.*;

@Data
@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PaymentStatusEvent {
    private String correlationID;
    private String orderID;
    private boolean orderStatus;
}
