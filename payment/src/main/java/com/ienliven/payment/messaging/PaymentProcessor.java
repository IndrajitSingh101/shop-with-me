package com.ienliven.payment.messaging;

import com.ienliven.payment.data.PaymentDetails;
import com.ienliven.payment.dto.PaymentInfo;
import com.ienliven.payment.enumerations.PaymentMode;
import com.ienliven.payment.processor.PaymentModeProcessor;
import com.ienliven.payment.repository.PaymentRepository;
import io.smallrye.reactive.messaging.annotations.Blocking;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class PaymentProcessor {

    @Inject
    PaymentRepository paymentRepository;

    @Inject
    @Channel("payment-status")
    Emitter<PaymentStatusEvent> paymentStatusEmitter;

    @Incoming("payment-request")
    @Blocking
    @Transactional
    public void processPaymentRequest(PaymentEvent paymentEvent){
        PaymentInfo paymentInfo=paymentEvent.getPaymentInfo();
        paymentRepository.persist(PaymentDetails.builder().
                paymentMode(paymentEvent.getPaymentInfo()
                        .getMode())
                        .paymentStatus(true)
                        .amount(paymentEvent.getPaymentInfo().getAmount())
                        .correlationID(paymentEvent.getCorrelationID())
                        .orderID(paymentEvent.getOrderID()).build());
        switch (paymentEvent.getPaymentInfo().getMode()){
            case UPI:
                PaymentModeProcessor.processUPIPayment().initiatePayment(paymentInfo);
                break;
            case NET_BANKING:
                PaymentModeProcessor.processNetBankingPayment().initiatePayment(paymentInfo);
                break;
            case WALLET:
                PaymentModeProcessor.processWalletPayment().initiatePayment(paymentInfo);
                break;

        }
        paymentStatusEmitter.send(PaymentStatusEvent.builder()
                .correlationID(paymentEvent.getCorrelationID())
                .orderStatus(true)
                .orderID(paymentEvent.getOrderID()).build());
    }
}
