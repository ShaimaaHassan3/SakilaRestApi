package com.myapi.persistence.repositoryImp.customer;

import com.myapi.persistence.PersistenceManager;
import com.myapi.persistence.entities.customer.Customer;
import com.myapi.persistence.entities.customer.Payment;
import com.myapi.persistence.entities.customer.Rental;
import com.myapi.persistence.repository.address.AddressRepo;
import com.myapi.persistence.repository.customer.CustomerRepo;
import com.myapi.persistence.repository.StoreRepo;
import com.myapi.persistence.repositoryImp.BaseRepoImp;
import com.myapi.persistence.repositoryImp.StoreRepoImp;
import com.myapi.persistence.repositoryImp.address.AddressRepoImp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.Set;
import java.util.stream.Collectors;


public class CustomerRepoImp extends BaseRepoImp<Customer> implements CustomerRepo {

    EntityManager entityManager;

    public CustomerRepoImp() {

        entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();

    }

    @Override
    public Set<Rental> getRentalsOfCustomer(int CustomerID) {
        String queryStr = "Select rentals from Customer c where c.id =: CustomerID";
        Query q = entityManager.createQuery(queryStr);
        q.setParameter("CustomerID", CustomerID);
//        Set<Rental> rentals = (Set<Rental>) q.getResultStream();
        return (Set<Rental>) q.getResultStream().collect(Collectors.toSet());
    }

    @Override
    public Set<Customer> getAllCustomers() {

        return getAll(new Customer());
    }

    @Override
    public Customer getCustomerById(int ID) {

        return getById(ID);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        delete(customer);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        AddressRepo addressRepo = new AddressRepoImp();
        StoreRepo storeRepo = new StoreRepoImp();
        customer.setAddress(addressRepo.getAddressById(customer.getAddress().getId()));
        customer.setStore(storeRepo.getStoreById(customer.getStore().getId()));
        return update(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        AddressRepo addressRepo = new AddressRepoImp();
        StoreRepo storeRepo = new StoreRepoImp();
        customer.setAddress(addressRepo.getAddressById(customer.getAddress().getId()));
        customer.setStore(storeRepo.getStoreById(customer.getStore().getId()));
        return update(customer);
    }

    @Override
    public Set<Payment> getAllPayment(int CustomerID) {
        String queryStr = "Select payments from Customer c where c.id =: CustomerID";
        Query q = entityManager.createQuery(queryStr);
        q.setParameter("CustomerID", CustomerID);
//        Set<Rental> rentals = (Set<Rental>) q.getResultStream();
        return (Set<Payment>) q.getResultStream().collect(Collectors.toSet());
    }

}

