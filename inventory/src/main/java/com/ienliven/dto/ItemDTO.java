package com.ienliven.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ItemDTO {
    private String categoryID;
    private String itemName;
    private String itemDescription;
    private Double price;
    private Integer itemQuantity;
    private String address;
    private String manufacturingCompany;
    private String vendorName;
}
