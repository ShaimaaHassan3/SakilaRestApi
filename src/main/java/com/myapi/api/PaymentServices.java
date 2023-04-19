package com.myapi.api;

import com.myapi.dtos.StaffDto;
import com.myapi.dtos.customer.CustomerDto;
import com.myapi.dtos.customer.PaymentDto;
import com.myapi.dtos.customer.RentalDto;
import com.myapi.services.PaymentService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.Set;

@Path("paymentsrvices")
public class PaymentServices {
    PaymentService service;

    public PaymentServices() {
        service = new PaymentService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("payments/{id}")
    public PaymentDto getPayment(@PathParam("id") int paymentID) {
        return service.getPaymentById(paymentID);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("payments/customer/{id}")
    public CustomerDto getCustomerPayment(@PathParam("id") int paymentID) {
        return service.getCustomerPayment(paymentID);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("payments")
    public Set<PaymentDto> getAllPayments() {
        return service.getAllPayment();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("payments/staff/{id}")
    public StaffDto getStaffProcessedPayment(@PathParam("id") int paymentID) {
        return service.getStaffProcessedPayment(paymentID);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("payments/rental/{id}")
    public RentalDto getRentalApplied(@PathParam("id") int paymentID) {
        return service.getRentalApplied(paymentID);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("payment")
    public PaymentDto addPayment(PaymentDto paymentDto) {
        return service.addPayment(paymentDto);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("payment")
    public PaymentDto updatePayment(PaymentDto paymentDto) {
        return service.updatePayment(paymentDto);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("payments/last/customer/{id}")
    public PaymentDto getLastPayment(@PathParam("id") int customerId) {
        return service.getLastPayment(customerId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("payments/amount/{amount}")
    public Set<PaymentDto> getPaymentWithAmount(@PathParam("amount") int customerId) {
        return service.getPaymentWithAmount(customerId);
    }

}
