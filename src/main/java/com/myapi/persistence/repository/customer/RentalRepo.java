package com.myapi.persistence.repository.customer;

import com.myapi.persistence.entities.Inventory;
import com.myapi.persistence.entities.Staff;
import com.myapi.persistence.entities.customer.Customer;
import com.myapi.persistence.entities.customer.Rental;

import java.util.Date;
import java.util.Set;

public interface RentalRepo {

    public Rental getRental(int rentalId);
    public Set<Rental> getAllRental();
    public Customer rentalCustomer(int rentalId);
    public Staff rentalStaff(int rentalId);
    public Inventory rentalInventory(int rentalId);
    public Date getRenatlDate(int rentalId);
    public Rental addRental(Rental rental);
    public Rental updateRental(Rental rental);

}
