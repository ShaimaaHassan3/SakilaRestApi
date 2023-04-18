package com.myapi.services;

import com.google.gson.reflect.TypeToken;
import com.myapi.dtos.StaffDto;
import com.myapi.dtos.StoreDto;
import com.myapi.dtos.address.AddressDto;
import com.myapi.dtos.customer.CustomerDto;
import com.myapi.persistence.entities.address.Address;
import com.myapi.persistence.repositoryImp.address.AddressRepoImp;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;
import java.util.Set;

public class AddressService {
    ModelMapper modelMapper;
    AddressRepoImp addressRepo;

    public AddressService() {
        modelMapper = new ModelMapper();
        addressRepo = new AddressRepoImp();
    }

    public Set<AddressDto> getAllAddresses() {
        Type type = new TypeToken<Set<AddressDto>>() {
        }.getType();
        return modelMapper.map(addressRepo.getAllAddresses(), type);
    }

    public AddressDto getAddressById(int ID) {
        return modelMapper.map(addressRepo.getAddressById(ID), AddressDto.class);
    }

    public AddressDto addNewAddress(AddressDto addressDto) {
        Address address = modelMapper.map(addressDto, Address.class);
        return modelMapper.map(addressRepo.createAddress(address), AddressDto.class);
    }

    public AddressDto updateAddress(AddressDto addressDto) {
        Address address = modelMapper.map(addressDto, Address.class);
        return modelMapper.map(addressRepo.updateAddress(address), AddressDto.class);
    }

    public Set<StoreDto> getAllStoriesInAddress(int ID) {
        Type type = new TypeToken<Set<StoreDto>>() {
        }.getType();
        Address address = addressRepo.getAddressById(ID);
        return modelMapper.map(address.getStores(), type);

    }

    public Set<CustomerDto> getAllCustomerInAddress(int ID) {
        Type type = new TypeToken<Set<CustomerDto>>() {
        }.getType();
        Address address = addressRepo.getAddressById(ID);
        return modelMapper.map(address.getCustomers(), type);

    }

    public Set<StaffDto> getAllStaffInAddress(int ID) {
        Type type = new TypeToken<Set<StaffDto>>() {
        }.getType();
        Address address = addressRepo.getAddressById(ID);
        return modelMapper.map(address.getStaff(), type);

    }
}

