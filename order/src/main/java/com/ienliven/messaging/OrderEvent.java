package com.ienliven.messaging;

import com.ienliven.enumerations.PaymentMode;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderEvent  {
    private String orderID;
    private String shoppingCartID;
    private String account;
    private PaymentMode mode;
}
