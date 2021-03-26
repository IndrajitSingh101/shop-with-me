package com.ienliven.service;

import com.ienliven.data.ShoppingCartItem;
import com.ienliven.dto.Cart;
import com.ienliven.repository.ShoppingCartRepository;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Inject
    ShoppingCartRepository shoppingCartRepository;

    @Override
    public void persistCartItems(Cart shoppingCart) {
        List<ShoppingCartItem> itemList=shoppingCart.getItems().stream().map(cartItem-> ShoppingCartItem.builder()
                .shoppingCartID(shoppingCart.getShoppingCartID())
                .sku(cartItem.getSku())
                .quantity(cartItem.getQuantity())
                .build()
        ).collect(Collectors.toList());
        shoppingCartRepository.persist(itemList.stream());
    }

    @Override
    public void updateCartItems(Cart shoppingCart) {
        shoppingCartRepository.updateShoppingCart(shoppingCart);
    }

    @Override
    public List<ShoppingCartItem> getShoppingCartItems(String shoppingCartID) {
        return shoppingCartRepository.list("shoppingCartID=?1",shoppingCartID);
    }
}
