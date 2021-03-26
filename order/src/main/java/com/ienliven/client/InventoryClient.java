package com.ienliven.client;

import com.ienliven.dto.Item;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Singleton
@Path("inventory")
@RegisterRestClient
public interface InventoryClient {
    @GET
    @Path("itemList")
    @Produces(MediaType.APPLICATION_JSON)
    Response itemList();

    @GET
    @Path("priceBySKU/{sku}")
    @Produces(MediaType.APPLICATION_JSON)
    Double getPrice(@PathParam String sku);

    @GET
    @Path("quantityBySKU/{sku}")
    @Produces(MediaType.APPLICATION_JSON)
    Long getRemainingQuantity(@PathParam String sku);
}
