package com.myapi.api;

import com.myapi.dtos.StaffDto;
import com.myapi.dtos.StoreDto;
import com.myapi.dtos.address.AddressDto;
import com.myapi.dtos.customer.CustomerDto;
import com.myapi.services.AddressService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

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
    public Set<AddressDto> getAllAddress() {
        return addressService.getAllAddresses();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("addresses/{id}")
    public AddressDto getAddressById(@PathParam("id") int ID) {
        return addressService.getAddressById(ID);
    }

    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("address")
    public AddressDto NewAddress(AddressDto addressDto) {
        return addressService.addNewAddress(addressDto);
    }

    @PUT()
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("address")
    public AddressDto updateAddress(AddressDto addressDto) {
        return addressService.updateAddress(addressDto);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("addresses/stories/{id}")
    public Set<StoreDto> getAllStoriesInAddress(@PathParam("id") int ID) {
        return addressService.getAllStoriesInAddress(ID);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("addresses/customers/{id}")
    public Set<CustomerDto> getAllCustomersInAddress(@PathParam("id") int ID) {
        return addressService.getAllCustomerInAddress(ID);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("addresses/staffs/{id}")
    public Set<StaffDto> getAllStaffInAddress(@PathParam("id") int ID) {
        return addressService.getAllStaffInAddress(ID);
    }
}
