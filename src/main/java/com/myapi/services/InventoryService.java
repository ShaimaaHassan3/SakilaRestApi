package com.myapi.services;

import com.google.gson.reflect.TypeToken;
import com.myapi.dtos.InventoryDto;
import com.myapi.dtos.StoreDto;
import com.myapi.dtos.address.AddressDto;
import com.myapi.dtos.film.FilmDto;
import com.myapi.persistence.entities.Inventory;
import com.myapi.persistence.repository.film.InventoryRepo;
import com.myapi.persistence.repositoryImp.film.InventoryRepoImp;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;
import java.util.Set;

public class InventoryService {
    InventoryRepo inventoryRepo;
    ModelMapper modelMapper;

    public InventoryService() {
        inventoryRepo = new InventoryRepoImp();
        modelMapper = new ModelMapper();
    }

    public InventoryDto getInventory(int inventoryId) {
        return modelMapper.map(inventoryRepo.getInventory(inventoryId), InventoryDto.class);
    }

    public FilmDto getFilm(int inventoryId) {
        return modelMapper.map(inventoryRepo.getFilm(inventoryId), FilmDto.class);
    }

    public Set<InventoryDto> getAllInventory() {
        Type type = new TypeToken<Set<InventoryDto>>() {
        }.getType();
        return modelMapper.map(inventoryRepo.getAllInventory(), type);
    }

    public StoreDto getStore(int inventoryId) {
        return modelMapper.map(inventoryRepo.getStore(inventoryId), StoreDto.class);
    }

    public InventoryDto addInventory(InventoryDto inventoryDto) {
        Inventory inventory = modelMapper.map(inventoryDto, Inventory.class);
        return modelMapper.map(inventoryRepo.addInventory(inventory), InventoryDto.class);
    }
    public InventoryDto updateInventory(InventoryDto inventoryDto) {
        Inventory inventory = modelMapper.map(inventoryDto, Inventory.class);
        return modelMapper.map(inventoryRepo.updateInventory(inventory), InventoryDto.class);
    }
}
