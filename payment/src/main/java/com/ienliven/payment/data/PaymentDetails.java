package com.ienliven.payment.data;

import com.ienliven.payment.enumerations.PaymentMode;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "payment_details")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDetails {
    @Id
    @GeneratedValue
    private Long paymentID;
    private String correlationID;
    private String orderID;
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
    private BigDecimal amount;
    private boolean paymentStatus;


}
