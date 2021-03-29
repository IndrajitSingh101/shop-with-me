package com.ienliven.data;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name="SHOPPINGCARTITEM")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShoppingCartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long sequenceID;
    private String shoppingCartID;
    private String sku;
    private Integer quantity;
}
