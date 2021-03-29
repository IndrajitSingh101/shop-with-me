package com.ienliven.service;


import com.ienliven.enumerations.OrderStatus;

public interface OrderService {
    public void persistOrder(String shoppingCartID, String orderID, OrderStatus orderStatus);
    public void updateOrder(String orderID,String shoppingCartID,OrderStatus orderStatus);
}
