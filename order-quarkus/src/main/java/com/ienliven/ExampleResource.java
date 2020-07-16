package com.ienliven;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
@OpenAPIDefinition(info = @Info(title = "simple test api", version = "0.0.1"))
public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary="sample endpoint")
    public String hello() {
        return "hello there";
    }
}