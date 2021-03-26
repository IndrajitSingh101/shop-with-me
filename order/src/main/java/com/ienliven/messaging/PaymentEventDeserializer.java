package com.ienliven.messaging;
import io.quarkus.kafka.client.serialization.JsonbDeserializer;


public class PaymentEventDeserializer extends JsonbDeserializer<PaymentEvent> {
    public PaymentEventDeserializer(){
        super(PaymentEvent.class);
    }
}
