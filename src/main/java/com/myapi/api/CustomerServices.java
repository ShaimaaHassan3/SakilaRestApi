package com.myapi.api;

import com.myapi.dtos.customer.CustomerDto;
import com.myapi.dtos.film.FilmDto;
import com.myapi.dtos.customer.PaymentDto;
import com.myapi.services.customer.CustomerService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.Set;

@Path("customerservices")
public class CustomerServices {
    CustomerService customerService;

    public CustomerServices() {
        customerService = new CustomerService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("customers/film/{id}")
    public Response getAllRentalFilm(@PathParam("id") int customerID, @Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<FilmDto>>(customerService.getRentalFilms(customerID)) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("customers")
    public Response getAllCustomers(@Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<CustomerDto>>(customerService.getAllCustomer()) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).link(self.getUri(), "self").build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("customers/{id}")
    public Response getCustomer(@PathParam("id") int Id, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(customerService.getCustomerById(Id)).link(self.getUri(), "self").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("customer")
    public Response newCustomer(CustomerDto customerDto, @Context UriInfo uriInfo) {
        System.out.println("New Customer : " + customerDto);
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        CustomerDto newCustomerDto = customerService.addCustomer(customerDto);
        if (newCustomerDto != null)
            return Response.ok("Added Successfully").link(self.getUri(), "self").build();
        return Response.ok("Cant Add Customer").link(self.getUri(), "self").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("customer")
    public Response updateCustomer(CustomerDto customerDto, @Context UriInfo uriInfo) {
        CustomerDto newCustomerDto = customerService.updateCustomer(customerDto);
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        if (newCustomerDto != null)
            return Response.ok("Updated Successfully").link(self.getUri(), "self").build();
        return Response.ok("Cant Update Customer").link(self.getUri(), "self").build();
    }

    @DELETE
    @Path("customer")
    public Response deleteCustomer(@PathParam("id") int id, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(customerService.deleteCustomer(id)).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("customer/payment/{id}")
    public Response getAllPayments(@PathParam("id") int customerId, @Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<PaymentDto>>(customerService.getAllPayments(customerId)) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).link(self.getUri(), "self").build();
    }
}
