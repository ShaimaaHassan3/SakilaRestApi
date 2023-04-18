package com.myapi.persistence.repository.customer;

import com.myapi.persistence.entities.customer.Customer;
import com.myapi.persistence.entities.customer.Payment;
import com.myapi.persistence.entities.customer.Rental;

import java.util.Set;

public interface CustomerRepo {

    public Set<Rental> getRentalsOfCustomer(int CustomerID);
    public Set<Customer> getAllCustomers();
    public Customer getCustomerById(int ID);
    public void deleteCustomer(Customer customer);
    public Customer createCustomer(Customer customer);
    public Customer updateCustomer (Customer customer);
    public Set<Payment> getAllPayment(int Id);


}
