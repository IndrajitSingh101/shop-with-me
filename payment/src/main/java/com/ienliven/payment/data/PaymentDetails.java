package com.ienliven.payment.data;

import com.ienliven.payment.enumerations.PaymentMode;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

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
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long sequenceID;
    private String correlationID;
    private String orderID;
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
    private BigDecimal amount;
    private boolean paymentStatus;


}
