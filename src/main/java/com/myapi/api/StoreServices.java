package com.myapi.api;

import com.myapi.dtos.InventoryDto;
import com.myapi.dtos.StaffDto;
import com.myapi.dtos.StoreDetailDto;
import com.myapi.dtos.StoreDto;
import com.myapi.dtos.customer.CustomerDto;
import com.myapi.services.StoreService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.Set;

@Path("storeservices")
public class StoreServices {
    StoreService service;

    public StoreServices() {
        service = new StoreService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("stories/{id}")
    public StoreDetailDto getStoreById(@PathParam("id") int ID) {
        return service.getStoreByID(ID);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("stories")
    public Set<StoreDetailDto> getAllStories() {
        return service.getAllStories();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("stories/manager/{id}")
    public StaffDto getManager(@PathParam("id") int ID) {
        return service.gatManager(ID);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
    @Path("store")
    public StoreDetailDto addStore(StoreDetailDto storeDetailDto) {
        System.out.println("Store : " + storeDetailDto);
        return service.addStore(storeDetailDto);
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON ,MediaType.APPLICATION_XML})
    @Path("store")
    public StoreDetailDto updateStore(StoreDetailDto storeDetailDto) {
        System.out.println("Store : " + storeDetailDto);
        return service.updateStore(storeDetailDto);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON )
    @Path("stories/inventories/{id}")
    public Set<InventoryDto> getAllInventory(@PathParam("id") int storeId) {
        return service.getAllInventoryDtoSet(storeId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("stories/staffs/{id}")
    public Set<StaffDto> getAllStaff(@PathParam("id") int storeID) {
        return service.getAllStaff(storeID);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("stories/customers/{id}")
    public Set<CustomerDto> getAllCustomer(@PathParam("id") int storeID) {
        return service.getAllCustomer(storeID);
    }
}
