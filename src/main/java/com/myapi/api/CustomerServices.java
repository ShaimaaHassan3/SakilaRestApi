package com.myapi.api;

import com.myapi.dtos.customer.CustomerDto;
import com.myapi.dtos.film.FilmDto;
import com.myapi.dtos.customer.PaymentDto;
import com.myapi.services.customer.CustomerService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

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
    public Set<FilmDto> getAllRentalFilm(@PathParam("id")int customerID) {

        Set<FilmDto> films = customerService.getRentalFilms(411);
        return films;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("customers")
    public Set<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomer();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("customers/{id}")
    public CustomerDto getCustomer(@PathParam("id") int Id) {
        return customerService.getCustomerById(Id);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("customer")
    public String newCustomer(CustomerDto customerDto) {
        System.out.println("New Customer : " + customerDto);
        CustomerDto newCustomerDto = customerService.addCustomer(customerDto);
        if (newCustomerDto != null)
            return "Added Successfully";
        return "Cant Add Customer";
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("customer")
    public String updateCustomer(CustomerDto customerDto) {
        CustomerDto newCustomerDto = customerService.updateCustomer(customerDto);
        if (newCustomerDto != null)
            return "Updated Successfully";
        return "Cant Update Customer";
    }
    @DELETE
    @Path("customer")
    public void deleteCustomer(@PathParam("id") int id) {
        customerService.deleteCustomer(id);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("customer/payment/{id}")
    public Set<PaymentDto> getAllPayments(@PathParam("id") int customerId) {
        return customerService.getAllPayments(customerId);
    }
}
