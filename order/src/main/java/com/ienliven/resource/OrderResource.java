package com.ienliven.resource;


import com.ienliven.client.InventoryClient;
import com.ienliven.data.ShoppingCartItem;
import com.ienliven.enumerations.OrderStatus;
import com.ienliven.messaging.OrderEvent;
import com.ienliven.messaging.PaymentEvent;
import com.ienliven.messaging.PaymentInfo;
import com.ienliven.service.OrderService;
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

    @Inject
    OrderService orderService;

    @POST
    @Path("processOrder")
    @Consumes(MediaType.APPLICATION_JSON)
    public void checkout(OrderEvent order){
        orderService.updateOrder(order, OrderStatus.CHECKOUT_INITIATED);

    }



}
