package com.myapi.persistence.repository.address;

import com.myapi.persistence.entities.address.Address;

import java.util.Set;

public interface AddressRepo {

    public Set<Address> getAllAddresses();

    public Address getAddressById(int ID);

    public void deleteAddress(Address customer);

    public Address createAddress(Address customer);

    public Address updateAddress(Address customer);
}
