package com.ienliven.data;

import com.ienliven.enumerations.OrderStatus;
import com.ienliven.enumerations.PaymentStatus;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity(name="ORDERS")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    private String orderID;
    private String shoppingCartID;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    private Double orderValue;

}
