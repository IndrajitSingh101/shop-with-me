package com.ienliven.service;


import com.ienliven.enumerations.OrderStatus;
import com.ienliven.messaging.OrderEvent;

public interface OrderService {
    public void persistOrder(String shoppingCartID, String orderID, OrderStatus orderStatus);
    public void updateOrder(OrderEvent order, OrderStatus orderStatus);
}
