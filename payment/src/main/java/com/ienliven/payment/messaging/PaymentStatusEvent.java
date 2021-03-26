package com.ienliven.payment.messaging;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@Builder
public class PaymentStatusEvent {
    private String correlationID;
    private String orderID;
    private boolean orderStatus;
}
