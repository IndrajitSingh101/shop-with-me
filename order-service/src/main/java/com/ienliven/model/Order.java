package com.ienliven.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Data
@Getter
@Setter
public class Order {
    private String orderID;
    private String userID;
    private List<Product> products;
    private BigDecimal totalAmount;
}
