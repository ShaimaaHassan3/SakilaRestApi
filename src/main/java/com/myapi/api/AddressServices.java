package com.myapi.api;

import com.myapi.dtos.StaffDto;
import com.myapi.dtos.StoreDto;
import com.myapi.dtos.address.AddressDto;
import com.myapi.dtos.customer.CustomerDto;
import com.myapi.dtos.film.ActorDto;
import com.myapi.services.AddressService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.Set;

@Path("addressservices")
public class AddressServices {
    AddressService addressService;

    public AddressServices() {
        addressService = new AddressService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("addresses")
    public Response getAllAddress(@Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<AddressDto>>(addressService.getAllAddresses()) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(addressService.getAllAddresses()).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("addresses/{id}")
    public Response getAddressById(@PathParam("id") int ID, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(addressService.getAddressById(ID)).link(self.getUri(), "self").build();
    }

    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("address")
    public Response NewAddress(AddressDto addressDto, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(addressService.addNewAddress(addressDto)).link(self.getUri(), "self").build();
    }

    @PUT()
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("address")
    public Response updateAddress(AddressDto addressDto, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(addressService.updateAddress(addressDto)).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("addresses/stories/{id}")
    public Response getAllStoriesInAddress(@PathParam("id") int ID, @Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<StoreDto>>(addressService.getAllStoriesInAddress(ID)) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("addresses/customers/{id}")
    public Response getAllCustomersInAddress(@PathParam("id") int ID, @Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<CustomerDto>>(addressService.getAllCustomerInAddress(ID)) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("addresses/staffs/{id}")
    public Response getAllStaffInAddress(@PathParam("id") int ID, @Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<StaffDto>>(addressService.getAllStaffInAddress(ID)) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).link(self.getUri(), "self").build();
    }
}
