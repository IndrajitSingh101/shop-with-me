package com.ienliven.data;

import com.ienliven.dto.ItemDTO;
import io.quarkus.mongodb.panache.MongoEntity;
import lombok.*;

import java.util.List;

@MongoEntity(collection = "Item")
@Data
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private String sku;
    private String categoryID;
    private ItemDetails itemDetails;
    private ManufactureDetails manufactureDetails;
    private VendorDetails vendorDetails;
    private Long availableQuantity;

    public Item convertFromDTO(ItemDTO itemDTO) {
        return Item.builder()
                .manufactureDetails(ManufactureDetails.builder().address(itemDTO.getAddress()).manufacturingCompany(itemDTO.getManufacturingCompany()).address(itemDTO.getAddress()).build())
                .availableQuantity(Long.valueOf(itemDTO.getItemQuantity()))
                .categoryID(itemDTO.getCategoryID())
                .sku(this.sku)
                .vendorDetails(VendorDetails.builder().vendorName(itemDTO.getVendorName()).address(itemDTO.getAddress()).location(Location.builder().build()).build())
                .itemDetails(ItemDetails.builder().itemDescription(itemDTO.getItemDescription()).price(itemDTO.getPrice()).itemName(itemDTO.getItemName()).build()).build();
    }
}
