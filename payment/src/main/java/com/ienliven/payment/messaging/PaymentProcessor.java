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
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import static com.ienliven.payment.enumerations.PaymentMode.*;

@ApplicationScoped
public class PaymentProcessor {
    private static final Logger LOGGER = Logger.getLogger(PaymentProcessor.class);
    @Inject
    PaymentRepository paymentRepository;

    @Inject
    @Channel("payment-status")
    Emitter<PaymentStatusEvent> paymentStatusEmitter;

    @Incoming("payment-request")
    @Blocking
    @Transactional
    public void processPaymentRequest(PaymentEvent paymentEvent){
        LOGGER.info("Payment request recieved: "+paymentEvent.toString());
        PaymentInfo paymentInfo=paymentEvent.getPaymentInfo();
        paymentRepository.persist(PaymentDetails.builder().
                paymentMode(PaymentMode.valueOf(paymentEvent.getPaymentInfo()
                        .getMode()))
                        .paymentStatus(true)
                        .amount(paymentEvent.getPaymentInfo().getAmount())
                        .correlationID(paymentEvent.getCorrelationID())
                        .orderID(paymentEvent.getOrderID()).build());
        switch (PaymentMode.valueOf(paymentEvent.getPaymentInfo().getMode())){
            case UPI:
                PaymentModeProcessor.processUPIPayment().initiatePayment(paymentInfo);
                break;
            case NET_BANKING:
                PaymentModeProcessor.processNetBankingPayment().initiatePayment(paymentInfo);
                break;
            case WALLET:
                PaymentModeProcessor.processWalletPayment().initiatePayment(paymentInfo);
                break;
            default:
                LOGGER.info("request processed");
        }
        paymentStatusEmitter.send(PaymentStatusEvent.builder()
                .correlationID(paymentEvent.getCorrelationID())
                .orderStatus(true)
                .orderID(paymentEvent.getOrderID()).build());
    }
}
