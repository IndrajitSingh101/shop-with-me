package com.ienliven.messaging;

import com.ienliven.data.Item;
import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class InventoryDeserializer extends ObjectMapperDeserializer<InventoryEvent> {
    public InventoryDeserializer() {
        super(InventoryEvent.class);
    }
}
