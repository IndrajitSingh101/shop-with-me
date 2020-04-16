package com.ienliven.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class OrderSerializers implements Serializer {
    @Override
    public byte[] serialize(String s, Object order) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(order).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }

    @Override
    public void configure(Map configs, boolean isKey) {

    }


    @Override
    public void close() {

    }
}
