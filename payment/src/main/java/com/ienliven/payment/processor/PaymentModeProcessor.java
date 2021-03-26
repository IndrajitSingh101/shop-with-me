package com.ienliven.payment.processor;

import com.ienliven.payment.dto.PaymentInfo;

//strategy pattern java 8 way
public interface PaymentModeProcessor {
    public void initiatePayment(PaymentInfo paymentInfo);

    static PaymentModeProcessor processNetBankingPayment(){
        return paymentInfo -> System.out.format("Payment info recieved: %s",paymentInfo.toString());
    }
    static PaymentModeProcessor processUPIPayment(){
        return paymentInfo -> System.out.format("Payment info recieved: %s",paymentInfo.toString());
    }
    static PaymentModeProcessor processWalletPayment(){
        return paymentInfo -> System.out.format("Payment info recieved: %s",paymentInfo.toString());
    }
}
