package com.ienliven.service;

import com.ienliven.client.InventoryClient;
import com.ienliven.data.Order;
import com.ienliven.data.ShoppingCartItem;
import com.ienliven.enumerations.OrderStatus;
import com.ienliven.enumerations.PaymentStatus;
import com.ienliven.messaging.PaymentEvent;
import com.ienliven.messaging.PaymentInfo;
import com.ienliven.repository.OrderRepository;
import com.ienliven.repository.ShoppingCartRepository;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@ApplicationScoped
public class OrderServiceImpl implements OrderService{
    private static final Logger LOGGER = Logger.getLogger(OrderServiceImpl.class);
    @Inject
    OrderRepository orderRepository;

    @Inject
    ShoppingCartRepository shoppingCartRepository;

    @RestClient
    @Inject
    InventoryClient client;

    @Inject
    @Channel("payment-request")
    Emitter<PaymentEvent> paymentEventEmitter;

    //common utility function to sum up the item values
    Function<List<ShoppingCartItem>,Double> totalAmount=(itemList)->{
        return itemList.stream().map(shoppingCartItem -> shoppingCartItem.getQuantity()*client.getPrice(shoppingCartItem.getSku()))
                .reduce(0.0,Double::sum);
    };

    @Override
    @Transactional
    public void persistOrder(String shoppingCartID, String orderID, OrderStatus orderStatus) {
        List<ShoppingCartItem> itemList=shoppingCartRepository.find("shoppingCartID=?1",shoppingCartID).list();
        Double cartValue=totalAmount.apply(itemList);
        orderRepository.persist(Order.builder()
                .orderID(orderID)
                .shoppingCartID(shoppingCartID)
                .orderStatus(orderStatus)
                .orderValue(cartValue)
                .build());
    }

    @Override
    @Transactional
    public void updateOrder(String orderID,String shoppingCartID, OrderStatus orderStatus) {
        List<ShoppingCartItem> itemList=shoppingCartRepository.find("shoppingCartID=?1",shoppingCartID).list();
        Double cartValue=totalAmount.apply(itemList);
        //updating the status of order
        orderRepository.update("orderStatus =?1, orderValue=?2 where orderID =?3", orderStatus,cartValue,orderID);
        sendForPayment(orderID,cartValue);
        //selectively updating teh order status
        if(orderStatus.name().equals(OrderStatus.CHECKOUT_INITIATED.name())){
            orderRepository.update("orderStatus =?1, orderValue=?2, paymentStatus=?3 where orderID =?4", OrderStatus.CHECKOUT_PROCESSED,cartValue,PaymentStatus.PENDING,orderID);
        }
    }

    private void sendForPayment(String orderID,Double cartValue){
        LOGGER.info("sending to payment service");
        // create payment request message
        PaymentEvent paymentEvent=PaymentEvent.builder().correlationID(UUID.randomUUID().toString())
                .orderID(orderID)
                .paymentInfo(PaymentInfo.builder().amount(BigDecimal.valueOf(cartValue)).build())
                .build();
        paymentEventEmitter.send(paymentEvent);
    }
}
