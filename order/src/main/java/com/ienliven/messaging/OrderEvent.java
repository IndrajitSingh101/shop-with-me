package com.ienliven.messaging;

import com.ienliven.payment.enumerations.PaymentMode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEvent  {
    private String orderID;
    private String shoppingCartID;
    private String account;
    private PaymentMode mode;
}
