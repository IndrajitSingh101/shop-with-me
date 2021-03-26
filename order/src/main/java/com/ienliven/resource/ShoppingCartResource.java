package com.ienliven.resource;

import com.ienliven.dto.Cart;
import com.ienliven.service.OrderService;
import com.ienliven.service.ShoppingCartService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("shopping-cart")
public class ShoppingCartResource {
    @Inject
    ShoppingCartService shoppingCartService;

    @Inject
    OrderService orderService;

    @PUT
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Cart addToShoppingCart(Cart shoppingCart){
        String orderID = "";
        String shoppingCartID="";
        // check if the order is new
        if(shoppingCart.getOrderID().isEmpty()) {
            shoppingCartID=String.format("sp-%s",UUID.randomUUID().toString());
            orderID=String.format("od-%s",UUID.randomUUID().toString());
            shoppingCart.setShoppingCartID(shoppingCartID);
            shoppingCartService.persistCartItems(shoppingCart);
            orderService.persistOrder(shoppingCartID,orderID);
        }else{
            shoppingCartService.updateCartItems(shoppingCart);
        }
        return shoppingCart;
    }
}
