package com.ienliven.resource;


import com.ienliven.client.InventoryClient;
import com.ienliven.data.ShoppingCartItem;
import com.ienliven.messaging.OrderEvent;
import com.ienliven.messaging.PaymentEvent;
import com.ienliven.messaging.PaymentInfo;
import com.ienliven.service.ShoppingCartService;
import io.smallrye.reactive.messaging.annotations.Broadcast;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Path("orders")
public class OrderResource {

    private static final Logger LOGGER = Logger.getLogger(OrderResource.class);

    @Inject
    ShoppingCartService shoppingCartService;
    //Rest client to call another service endpoint
    @Inject
    @RestClient
    InventoryClient inventoryClient;

    @Inject
    @Channel("payment-request")
    Emitter<PaymentEvent> paymentEventEmitter;

    @POST
    @Path("processOrder")
    @Consumes(MediaType.APPLICATION_JSON)
    public void checkout(OrderEvent order){
       List<ShoppingCartItem> shoppingCartItemList= shoppingCartService.getShoppingCartItems(order.getShoppingCartID());
        Double totalPrice=shoppingCartItemList.stream().map(shoppingCartItem -> shoppingCartItem.getQuantity()*inventoryClient.getPrice(shoppingCartItem.getSku()))
                .reduce(0.0,Double::sum);
       // create payment request message
        PaymentEvent paymentEvent=PaymentEvent.builder().correlationID(UUID.randomUUID().toString())
                .orderID(order.getOrderID())
                .paymentInfo(PaymentInfo.builder().account(order.getAccount()).amount(BigDecimal.valueOf(totalPrice)).mode(order.getMode()).build())
                .build();
        paymentEventEmitter.send(paymentEvent);
    }



}
