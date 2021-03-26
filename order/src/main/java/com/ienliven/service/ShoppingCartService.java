package com.ienliven.service;

import com.ienliven.data.ShoppingCartItem;
import com.ienliven.dto.Cart;

import java.util.List;

public interface ShoppingCartService {
    public void persistCartItems(Cart cart);
    void updateCartItems(Cart shoppingCart);
    List<ShoppingCartItem> getShoppingCartItems(String shoppingCartID);

}
