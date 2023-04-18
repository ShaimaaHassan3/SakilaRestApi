package com.myapi.persistence.repositoryImp.customer;

import com.myapi.persistence.entities.Inventory;
import com.myapi.persistence.entities.Staff;
import com.myapi.persistence.entities.customer.Customer;
import com.myapi.persistence.entities.customer.Rental;
import com.myapi.persistence.repository.StaffRepo;
import com.myapi.persistence.repository.customer.CustomerRepo;
import com.myapi.persistence.repository.film.InventoryRepo;
import com.myapi.persistence.repository.customer.RentalRepo;
import com.myapi.persistence.repositoryImp.BaseRepoImp;
import com.myapi.persistence.repositoryImp.StaffRepoImp;
import com.myapi.persistence.repositoryImp.film.InventoryRepoImp;

import java.util.Date;
import java.util.Set;

public class RentalRepoImp extends BaseRepoImp<Rental> implements RentalRepo {
    @Override
    public Rental getRental(int rentalId) {
        return getById(rentalId);
    }

    @Override
    public Set<Rental> getAllRental() {
        return getAll(new Rental());
    }

    @Override
    public Customer rentalCustomer(int rentalId) {
        Rental rental = getRental(rentalId);
        return rental.getCustomer();
    }

    @Override
    public Staff rentalStaff(int rentalId) {
        Rental rental = getRental(rentalId);
        return rental.getStaff();
    }

    @Override
    public Inventory rentalInventory(int rentalId) {
        Rental rental = getRental(rentalId);
        return rental.getInventory();
    }

    @Override
    public Date getRenatlDate(int rentalId) {
        Rental rental = getRental(rentalId);
        return rental.getRentalDate();
    }

    @Override
    public Rental addRental(Rental rental) {
        CustomerRepo customerRepo = new CustomerRepoImp();
        StaffRepo staffRepo = new StaffRepoImp();
        InventoryRepo inventoryRepo = new InventoryRepoImp();
        Customer customer = customerRepo.getCustomerById(rental.getCustomer().getId());
        Staff staff = staffRepo.getStaffById(rental.getStaff().getId());
        Inventory inventory = inventoryRepo.getInventory(rental.getInventory().getId());
        rental.setCustomer(customer);
        rental.setStaff(staff);
        rental.setInventory(inventory);
        return save(rental);
    }

    @Override
    public Rental updateRental(Rental rental) {
        CustomerRepo customerRepo = new CustomerRepoImp();
        StaffRepo staffRepo = new StaffRepoImp();
        InventoryRepo inventoryRepo = new InventoryRepoImp();
        Customer customer = customerRepo.getCustomerById(rental.getCustomer().getId());
        Staff staff = staffRepo.getStaffById(rental.getStaff().getId());
        Inventory inventory = inventoryRepo.getInventory(rental.getInventory().getId());
        rental.setCustomer(customer);
        rental.setStaff(staff);
        rental.setInventory(inventory);
        return update(rental);
    }


}
