package com.myapi.api;

import com.myapi.dtos.InventoryDto;
import com.myapi.dtos.StoreDto;
import com.myapi.dtos.film.FilmDto;
import com.myapi.services.InventoryService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.Set;

@Path("inventoryervices")
public class InventoryServices {
    InventoryService service;

    public InventoryServices() {
        service = new InventoryService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("inventories/{id}")
    public Response getInventory(@PathParam("id") int inventoryId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.getInventory(inventoryId)).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("inventories/film/{id}")
    public Response getFilm(@PathParam("id") int inventoryId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.getFilm(inventoryId)).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("inventories")
    public Response getAllInventory(@Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<InventoryDto>>(service.getAllInventory()) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).link(self.getUri(), "self").build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("inventories/store/{id}")
    public Response getStore(@PathParam("id") int inventoryId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.getStore(inventoryId)).link(self.getUri(), "self").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("inventory")
    public Response addInventory(InventoryDto inventory, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.addInventory(inventory)).link(self.getUri(), "self").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("inventory")
    public Response updateInventory(InventoryDto inventory, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.updateInventory(inventory)).link(self.getUri(), "self").build();

    }
}
