package com.myapi.api;

import com.myapi.dtos.InventoryDto;
import com.myapi.dtos.StaffDto;
import com.myapi.dtos.customer.CustomerDto;
import com.myapi.dtos.customer.RentalDto;
import com.myapi.dtos.film.FilmDto;
import com.myapi.services.customer.RentalService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.Date;
import java.util.Set;

@Path("rentalsvices")
public class RentalServices {
    RentalService service;

    public RentalServices() {
        service = new RentalService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("rentals/{id}")
    public Response getRental(@PathParam("id") int rentalID, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.getRental(rentalID)).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("rentals")
    public Response getAllRental(@Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<RentalDto>>(service.getAllRental()) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("rentals/customer/{id}")
    public Response getCustomerWoRental(@PathParam("id") int rentalId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.getCustomerWhoRental(rentalId)).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("rentals/staff/{id}")
    public Response getStaffProcessedRental(@PathParam("id") int rentalId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.getStaffRental(rentalId)).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("rentals/inventory/{id}")
    public Response getRentalInventory(@PathParam("id") int rentalId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.getRentalInventory(rentalId)).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("rental/{id}")
    public Response getRenatlDate(@PathParam("id") int rentalId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.getRenatlDate(rentalId)).link(self.getUri(), "self").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("rental")
    public Response addRentalDto(RentalDto rentalDto, @Context UriInfo uriInfo) {
        System.out.println("Rental : " + rentalDto);
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.addRental(rentalDto)).link(self.getUri(), "self").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("rental")
    public Response updateRentalDto(RentalDto rentalDto, @Context UriInfo uriInfo) {
        System.out.println("Rental : " + rentalDto);
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.updateRental(rentalDto)).link(self.getUri(), "self").build();
    }
}
