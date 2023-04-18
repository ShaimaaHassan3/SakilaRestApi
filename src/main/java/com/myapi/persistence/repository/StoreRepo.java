package com.myapi.persistence.repository;

import com.myapi.persistence.entities.Staff;
import com.myapi.persistence.entities.Store;

import java.util.Set;

public interface StoreRepo {

    public Store getStoreById(int ID);
    public Set<Store> getAllStories();
    public Staff getManager(int storeId);
    public Store addStore(Store store);
    public Store updateStore(Store store);

}
