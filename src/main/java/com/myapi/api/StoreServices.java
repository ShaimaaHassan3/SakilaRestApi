package com.myapi.api;

import com.myapi.dtos.InventoryDto;
import com.myapi.dtos.StaffDto;
import com.myapi.dtos.StoreDetailDto;
import com.myapi.dtos.StoreDto;
import com.myapi.dtos.customer.CustomerDto;
import com.myapi.dtos.customer.PaymentDto;
import com.myapi.services.StoreService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

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
    public Response getStoreById(@PathParam("id") int ID, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.getStoreByID(ID)).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("stories")
    public Response getAllStories(@Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<StoreDetailDto>>(service.getAllStories()) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).link(self.getUri(), "self").build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("stories/manager/{id}")
    public Response getManager(@PathParam("id") int ID, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.gatManager(ID)).link(self.getUri(), "self").build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("store")
    public Response addStore(StoreDetailDto storeDetailDto, @Context UriInfo uriInfo) {
        System.out.println("Store : " + storeDetailDto);
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.addStore(storeDetailDto)).link(self.getUri(), "self").build();
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("store")
    public Response updateStore(StoreDetailDto storeDetailDto, @Context UriInfo uriInfo) {
        System.out.println("Store : " + storeDetailDto);
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.updateStore(storeDetailDto)).link(self.getUri(), "self").build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("stories/inventories/{id}")
    public Response getAllInventory(@PathParam("id") int storeId, @Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<InventoryDto>>(service.getAllInventoryDtoSet(storeId)) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("stories/staffs/{id}")
    public Response getAllStaff(@PathParam("id") int storeID, @Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<StaffDto>>(service.getAllStaff(storeID)) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("stories/customers/{id}")
    public Response getAllCustomer(@PathParam("id") int storeID, @Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<CustomerDto>>(service.getAllCustomer(storeID)) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).link(self.getUri(), "self").build();
    }
}
