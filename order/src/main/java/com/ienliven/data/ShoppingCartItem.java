package com.ienliven.data;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="SHOPPINGCARTITEM")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShoppingCartItem {
    private String shoppingCartID;
    private String sku;
    private Integer quantity;
}
