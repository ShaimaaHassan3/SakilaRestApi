package com.myapi.persistence.repositoryImp.address;

import com.myapi.persistence.entities.address.Address;
import com.myapi.persistence.entities.address.City;
import com.myapi.persistence.repository.address.AddressRepo;
import com.myapi.persistence.repository.address.CityRepo;
import com.myapi.persistence.repositoryImp.BaseRepoImp;

import java.util.Set;

public class AddressRepoImp extends BaseRepoImp<Address> implements AddressRepo {


    @Override
    public Set<Address> getAllAddresses() {
        return getAll(new Address());
    }

    @Override
    public Address getAddressById(int ID) {
        return getById(ID);
    }

    @Override
    public void deleteAddress(Address address) {
        delete(address);
    }

    @Override
    public Address createAddress(Address address) {
        CityRepo cityRepo = new CityRepoImp();
        City city = cityRepo.getCityById(address.getCity().getId());
        address.setCity(city);
        return update(address);
    }

    @Override
    public Address updateAddress(Address address) {
        CityRepo cityRepo = new CityRepoImp();
        City city = cityRepo.getCityById(address.getCity().getId());
        address.setCity(city);
        return update(address);
    }

}


