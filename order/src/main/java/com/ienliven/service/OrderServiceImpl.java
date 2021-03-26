package com.ienliven.service;

import com.ienliven.data.Order;
import com.ienliven.enumerations.PaymentStatus;
import com.ienliven.repository.OrderRepository;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class OrderServiceImpl implements OrderService{
    @Inject
    OrderRepository orderRepository;

    @Override
    public void persistOrder(String shoppingCartID,String orderID) {
        orderRepository.persist(Order.builder()
                .orderID(orderID)
                .shoppingCartID(shoppingCartID)
                .paymentStatus(PaymentStatus.PENDING).build());
    }
}
