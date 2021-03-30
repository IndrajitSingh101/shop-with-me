package com.ienliven.messaging;

import io.quarkus.kafka.client.serialization.JsonbDeserializer;

public class PaymentStatusEventDeserializer extends JsonbDeserializer<PaymentStatusEvent> {
public PaymentStatusEventDeserializer(){
    super(PaymentStatusEvent.class);
}
}
