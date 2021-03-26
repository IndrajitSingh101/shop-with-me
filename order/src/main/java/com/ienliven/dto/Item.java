package com.ienliven.dto;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private String sku;
    private Integer quantity;
    private BigDecimal price;
}
