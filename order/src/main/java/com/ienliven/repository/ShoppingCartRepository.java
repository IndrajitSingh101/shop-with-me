package com.ienliven.repository;

import com.ienliven.data.ShoppingCartItem;
import com.ienliven.dto.Cart;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.function.Consumer;

@ApplicationScoped
public class ShoppingCartRepository implements PanacheRepository<ShoppingCartItem> {
    Consumer<ShoppingCartItem> shoppingCartItemConsumer=shoppingCartItem -> {
        ShoppingCartItem item=find("shoppingCartID=?1 and sku=?2",shoppingCartItem.getShoppingCartID(),shoppingCartItem.getSku()).firstResult();
        if(item==null){
            persist(shoppingCartItem);
        }else{
            item.setQuantity(shoppingCartItem.getQuantity());
            persist(item);
        }
    };

 public void updateShoppingCart(Cart shoppingCart){
     delete("shoppingCartID=?",shoppingCart.getShoppingCartID());
     shoppingCart.getItems().stream().map(item->ShoppingCartItem.builder().sku(item.getSku()).quantity(item.getQuantity())
             .shoppingCartID(shoppingCart.getShoppingCartID()).build())
             .forEach(shoppingCartItem->shoppingCartItemConsumer.accept(shoppingCartItem));
 }
}
