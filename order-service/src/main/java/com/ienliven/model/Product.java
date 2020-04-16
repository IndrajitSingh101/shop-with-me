package com.ienliven.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
public class Product {
    String id;
    String categoryId;
    String productName;
    String quantity;
    BigDecimal unitPrice;
}
