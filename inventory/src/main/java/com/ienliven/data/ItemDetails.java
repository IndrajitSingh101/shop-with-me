package com.ienliven.data;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDetails {
    private String itemName;
    private String itemDescription;
    private String imageURL;
    private double price;
}
