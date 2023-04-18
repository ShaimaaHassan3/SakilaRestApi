package com.myapi.services;

import com.google.gson.reflect.TypeToken;
import com.myapi.dtos.InventoryDto;
import com.myapi.dtos.StaffDto;
import com.myapi.dtos.StoreDetailDto;
import com.myapi.dtos.StoreDto;
import com.myapi.dtos.address.AddressDto;
import com.myapi.dtos.customer.CustomerDto;
import com.myapi.dtos.customer.PaymentDto;
import com.myapi.persistence.entities.Inventory;
import com.myapi.persistence.entities.Staff;
import com.myapi.persistence.entities.Store;
import com.myapi.persistence.entities.address.Address;
import com.myapi.persistence.entities.customer.Customer;
import com.myapi.persistence.repository.StoreRepo;
import com.myapi.persistence.repositoryImp.StoreRepoImp;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class StoreService {
    StoreRepo storeRepo;
    ModelMapper modelMapper;

    public StoreService() {
        storeRepo = new StoreRepoImp();
        modelMapper = new ModelMapper();
    }

    public StoreDetailDto getStoreByID(int ID) {
        return modelMapper.map(storeRepo.getStoreById(ID), StoreDetailDto.class);
    }

    public Set<StoreDetailDto> getAllStories() {
        Type type = new TypeToken<Set<StoreDetailDto>>() {
        }.getType();
        return modelMapper.map(storeRepo.getAllStories(), type);
    }

    public StaffDto gatManager(int storeId) {
        return modelMapper.map(storeRepo.getManager(storeId), StaffDto.class);
    }

    public StoreDetailDto addStore(StoreDetailDto storeDetailDto) {
        Store store = modelMapper.map(storeDetailDto, Store.class);
        return modelMapper.map(storeRepo.addStore(store), StoreDetailDto.class);
    }

    public StoreDetailDto updateStore(StoreDetailDto storeDetailDto) {
        Store store = modelMapper.map(storeDetailDto, Store.class);
        return modelMapper.map(storeRepo.updateStore(store), StoreDetailDto.class);
    }

    public Set<InventoryDto> getAllInventoryDtoSet(int storeID) {
        Store store = storeRepo.getStoreById(storeID);
        Set<InventoryDto> inventoryDtos = new HashSet<>();
        for (Inventory inventory : store.getInventories()) {
            inventoryDtos.add(modelMapper.map(inventory, InventoryDto.class));
        }
        return inventoryDtos;
    }

    public Set<StaffDto> getAllStaff(int storeID) {
        Store store = storeRepo.getStoreById(storeID);
        Set<StaffDto> staffDtos = new HashSet<>();
        for (Staff staff : store.getStaff()) {
            staffDtos.add(modelMapper.map(staff, StaffDto.class));
        }
        return staffDtos;
    }

    public Set<CustomerDto> getAllCustomer(int storeID) {
        Store store = storeRepo.getStoreById(storeID);
        Set<CustomerDto> staffDtos = new HashSet<>();
        for (Customer customer : store.getCustomers()) {
            staffDtos.add(modelMapper.map(customer, CustomerDto.class));
        }
        return staffDtos;
    }
}
