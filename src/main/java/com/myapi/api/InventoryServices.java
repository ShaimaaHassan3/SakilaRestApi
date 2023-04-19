package com.myapi.api;

import com.myapi.dtos.InventoryDto;
import com.myapi.dtos.StoreDto;
import com.myapi.dtos.film.FilmDto;
import com.myapi.services.InventoryService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

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
    public InventoryDto getInventory(@PathParam("id") int inventoryId) {
        return service.getInventory(inventoryId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("inventories/film/{id}")
    public FilmDto getFilm(@PathParam("id") int inventoryId) {
        return service.getFilm(inventoryId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("inventories")
    public Set<InventoryDto> getAllInventory() {
        return service.getAllInventory();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("inventories/store/{id}")
    public StoreDto getStore(@PathParam("id") int inventoryId) {
        return service.getStore(inventoryId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("inventory")
    public InventoryDto addInventory(InventoryDto inventory) {
        return service.addInventory(inventory);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("inventory")
    public InventoryDto updateInventory(InventoryDto inventory) {
        return service.updateInventory(inventory);
    }
}
