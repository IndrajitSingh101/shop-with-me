package com.ienliven.resource;

import com.ienliven.data.Category;
import com.ienliven.data.Item;
import com.ienliven.dto.CategoryDTO;
import com.ienliven.dto.ItemDTO;
import com.ienliven.enumeration.InventoryOperationStatus;
import com.ienliven.service.InventoryService;
import com.ienliven.service.InventoryServiceImpl;
import org.eclipse.microprofile.opentracing.Traced;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Traced
@Path("inventory")
public class InventoryResource {
    private static final Logger LOGGER = Logger.getLogger(InventoryResource.class);
    @Inject
    InventoryService inventoryService;

    @POST
    @Path("publishItem")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response publishItem(List<ItemDTO> itemList) {
        for(ItemDTO item:itemList) {
            LOGGER.info(item.toString());
            inventoryService.persistItemDetails(new Item().convertFromDTO(item));
        }
        return Response.ok(InventoryOperationStatus.ITEM_PERSISTED.name()).build();
    }

    @PUT
    @Path("addCategory")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCategory(List<CategoryDTO> categoryList){
        for (CategoryDTO categoryDTO : categoryList) {
            inventoryService.addCategory(new Category().convertFromDTO(categoryDTO));
        }
        return Response.ok(InventoryOperationStatus.CATEGORY_PERSISTED.name()).build();
    }

    @GET
    @Path("itemList")
    @Produces(MediaType.APPLICATION_JSON)
    public Response itemList() {
        List<Item> itemList = inventoryService.getItems();
        return Response.ok(itemList).build();
    }

    @GET
    @Path("itemByCategory/{category}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response itemByCategory(@PathParam("category") String category) {
        List<Item> itemList = inventoryService.getItemsByCategory(category);
        return Response.ok(itemList).build();
    }

    @GET
    @Path("priceBySKU/{sku}")
    @Produces(MediaType.APPLICATION_JSON)
    public Double getPrice(@PathParam("sku") String sku){
        return inventoryService.getItemBySKU(sku).getItemDetails().getPrice();
    }

    @GET
    @Path("quantityBySKU/{sku}")
    @Produces(MediaType.APPLICATION_JSON)
    public Long getRemainingQuantity(@PathParam String sku){
        return inventoryService.getItemBySKU(sku).getAvailableQuantity();
    }

    @GET
    @Path("getCategories")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategories(){
        List<Category> categories=inventoryService.getCategories();
        return Response.ok(categories).build();
    }

}