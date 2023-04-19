package com.myapi.api;

import com.myapi.dtos.StaffDto;
import com.myapi.dtos.customer.CustomerDto;
import com.myapi.dtos.customer.PaymentDto;
import com.myapi.dtos.customer.RentalDto;
import com.myapi.dtos.film.LanguageDto;
import com.myapi.services.PaymentService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

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
    public Response getPayment(@PathParam("id") int paymentID, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.getPaymentById(paymentID)).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("payments/customer/{id}")
    public Response getCustomerPayment(@PathParam("id") int paymentID, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.getCustomerPayment(paymentID)).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("payments")
    public Response getAllPayments(@Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<PaymentDto>>(service.getAllPayment()) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("payments/staff/{id}")
    public Response getStaffProcessedPayment(@PathParam("id") int paymentID, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.getStaffProcessedPayment(paymentID)).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("payments/rental/{id}")
    public Response getRentalApplied(@PathParam("id") int paymentID, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.getRentalApplied(paymentID)).link(self.getUri(), "self").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("payment")
    public Response addPayment(PaymentDto paymentDto, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.addPayment(paymentDto)).link(self.getUri(), "self").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("payment")
    public Response updatePayment(PaymentDto paymentDto, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.updatePayment(paymentDto)).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("payments/last/customer/{id}")
    public Response getLastPayment(@PathParam("id") int customerId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.getLastPayment(customerId)).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("payments/amount/{amount}")
    public Response getPaymentWithAmount(@PathParam("amount") int customerId, @Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<PaymentDto>>(service.getPaymentWithAmount(customerId)) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).link(self.getUri(), "self").build();

    }

}
