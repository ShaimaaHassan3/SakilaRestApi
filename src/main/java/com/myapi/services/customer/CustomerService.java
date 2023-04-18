package com.myapi.services.customer;

import com.google.gson.reflect.TypeToken;
import com.myapi.dtos.customer.CustomerDto;
import com.myapi.dtos.film.FilmDto;
import com.myapi.dtos.customer.PaymentDto;
import com.myapi.persistence.entities.customer.Customer;
import com.myapi.persistence.entities.customer.Rental;
import com.myapi.persistence.repositoryImp.customer.CustomerRepoImp;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class CustomerService {
    private ModelMapper modelMapper;
    CustomerRepoImp customerRepo;

    public CustomerService() {
        customerRepo = new CustomerRepoImp();
        modelMapper = new ModelMapper();
    }

    public Set<FilmDto> getRentalFilms(int customerID) {

        Set<Rental> rentalSet = customerRepo.getRentalsOfCustomer(411);
        Set<FilmDto> films = new HashSet<>();
        for (Rental rental : rentalSet) {
            films.add(modelMapper.map(rental.getInventory().getFilm(), FilmDto.class));
        }
//        Type type = new TypeToken<Set<Film>>() {
//        }.getType();
//        return modelMapper.map(films, type);
        return films;
    }

    public Set<CustomerDto> getAllCustomer() {
        Type type = new TypeToken<Set<CustomerDto>>() {
        }.getType();
        return modelMapper.map(customerRepo.getAllCustomers(), type);
    }

    public CustomerDto getCustomerById(int ID) {
        return modelMapper.map(customerRepo.getCustomerById(ID), CustomerDto.class);
    }

    public CustomerDto addCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        return modelMapper.map(customerRepo.createCustomer(customer), CustomerDto.class);
    }

    public CustomerDto updateCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        return modelMapper.map(customerRepo.updateCustomer(customer), CustomerDto.class);
    }

    public void deleteCustomer(int id) {
        Customer customer2 = customerRepo.getCustomerById(id);
//        Customer customer = modelMapper.map(customerDto, Customer.class);
        customerRepo.deleteCustomer(customer2);
    }

    public Set<PaymentDto> getAllPayments(int customerId) {
        Type type = new TypeToken<Set<PaymentDto>>() {
        }.getType();
        return modelMapper.map(customerRepo.getAllPayment(customerId),type);
    }

}
