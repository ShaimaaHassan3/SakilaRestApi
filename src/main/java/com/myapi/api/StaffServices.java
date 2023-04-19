package com.myapi.api;

import com.myapi.dtos.StaffDto;
import com.myapi.dtos.customer.PaymentDto;
import com.myapi.dtos.customer.RentalDto;;
import com.myapi.services.StaffService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Path("staffsrvices")
public class StaffServices {
    StaffService service;

    public StaffServices() {
        service = new StaffService();
    }

    @GET
    @Path("staffs")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllStaff(@Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<StaffDto>>(service.getAllStaff()) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).links(self).build();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getStaffByID(@PathParam("id") int staffID, @Context UriInfo uriInfo) {
        StaffDto staffDto = service.getStaffById(staffID);
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        Link link = Link.fromPath(uriInfo.getBaseUri().toString().concat("staff")).build();
        List<Link> links = new ArrayList<>();
        links.add(self);
        links.add(link);
        staffDto.setLinks(links);
        return Response.ok(staffDto).link(self.getUri(), "self").link(link.getUri(), "getAllStaff").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("staff")
    public Response addStaff(StaffDto staffDto, @Context UriInfo uriInfo) {
        Link link = Link.fromPath(uriInfo.getBaseUri().toString().concat("staff/")).build();
        service.addStaff(staffDto);
        return Response.ok().link(link.getUri(), "showAllStaffs").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("staff")
    public Response updateStaff(StaffDto staffDto, @Context UriInfo uriInfo) {
        Link link = Link.fromPath(uriInfo.getBaseUri().toString().concat("staff/")).build();
        service.updateStaff(staffDto);
        return Response.ok().link(link.getUri(), "showAllStaffs").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("staffs/{fName}-{lName}")
    public StaffDto getStaffByName(@PathParam("fName") String fName, @PathParam("lName") String lName) {
        return service.getStaffByName(fName, lName);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("staffs/rental/{id}")
    public Response getAllRentalByStaff(@PathParam("id") int staffID, @Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<RentalDto>>(service.getAllRentalByStaff(staffID)) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).links(self).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("staffs/payment/{id}")
    public Response getAllPaymentByStaff(@PathParam("id")int staffId, @Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<PaymentDto>>(service.getAllPaymentByStaff(staffId)) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).links(self).build();
    }
}
