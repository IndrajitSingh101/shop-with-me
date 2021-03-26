package com.ienliven.dto;

import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cart {
    private String orderID;
    private String shoppingCartID;
    private List<Item> items;
}
