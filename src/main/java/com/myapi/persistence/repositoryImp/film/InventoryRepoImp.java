package com.myapi.persistence.repositoryImp.film;

import com.myapi.persistence.entities.Inventory;
import com.myapi.persistence.entities.Store;
import com.myapi.persistence.entities.film.Film;
import com.myapi.persistence.repository.StoreRepo;
import com.myapi.persistence.repository.film.FilmRepo;
import com.myapi.persistence.repository.film.InventoryRepo;
import com.myapi.persistence.repositoryImp.BaseRepoImp;
import com.myapi.persistence.repositoryImp.StoreRepoImp;

import java.util.Set;

public class InventoryRepoImp extends BaseRepoImp<Inventory> implements InventoryRepo {
    @Override
    public Inventory getInventory(int inventoryId) {
        return getById(inventoryId);
    }

    @Override
    public Film getFilm(int inventoryId) {
        Inventory inventory = getInventory(inventoryId);
        return inventory.getFilm();
    }

    @Override
    public Set<Inventory> getAllInventory() {
        return getAll(new Inventory());
    }

    @Override
    public Store getStore(int inventoryId) {
        Inventory inventory = getInventory(inventoryId);
        return inventory.getStore();
    }

    @Override
    public Inventory addInventory(Inventory inventory) {
        FilmRepo filmRepo = new FilmRepoImp();
        StoreRepo storeRepo = new StoreRepoImp();
        Film film = filmRepo.getFilmById(inventory.getFilm().getId());
        Store store = storeRepo.getStoreById(inventory.getStore().getId());
        inventory.setFilm(film);
        inventory.setStore(store);
        return save(inventory);
    }

    @Override
    public Inventory updateInventory(Inventory inventory) {
        FilmRepo filmRepo = new FilmRepoImp();
        StoreRepo storeRepo = new StoreRepoImp();
        Film film = filmRepo.getFilmById(inventory.getFilm().getId());
        Store store = storeRepo.getStoreById(inventory.getStore().getId());
        inventory.setFilm(film);
        inventory.setStore(store);
        return update(inventory);
    }
}
