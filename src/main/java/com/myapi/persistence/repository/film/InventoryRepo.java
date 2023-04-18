package com.myapi.persistence.repository.film;

import com.myapi.persistence.entities.Inventory;
import com.myapi.persistence.entities.Store;
import com.myapi.persistence.entities.film.Film;

import java.util.Set;

public interface InventoryRepo {
    public Inventory getInventory(int inventoryId);
    public Film getFilm(int inventoryId);
    public Set<Inventory> getAllInventory();
    public Store getStore(int inventoryId);
    public Inventory addInventory(Inventory inventory);
    public Inventory updateInventory(Inventory inventory);

}
