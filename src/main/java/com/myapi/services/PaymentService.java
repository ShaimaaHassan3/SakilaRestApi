package com.myapi.services;

import com.google.gson.reflect.TypeToken;
import com.myapi.dtos.StaffDto;
import com.myapi.dtos.customer.CustomerDto;
import com.myapi.dtos.customer.PaymentDto;
import com.myapi.dtos.customer.RentalDto;
import com.myapi.persistence.entities.customer.Payment;
import com.myapi.persistence.repository.customer.PaymentRepo;
import com.myapi.persistence.repositoryImp.customer.PaymentRepoImp;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;
import java.util.Set;

public class PaymentService {
    PaymentRepo paymentRepo;
    ModelMapper modelMapper;

    public PaymentService() {
        paymentRepo = new PaymentRepoImp();
        modelMapper = new ModelMapper();
    }

    public PaymentDto getPaymentById(int paymentId) {
        return modelMapper.map(paymentRepo.getPaymentById(paymentId), PaymentDto.class);
    }

    public CustomerDto getCustomerPayment(int paymentId) {
        return modelMapper.map(paymentRepo.getCustomerPayment(paymentId), CustomerDto.class);
    }

    public Set<PaymentDto> getAllPayment() {
        Type type = new TypeToken<Set<PaymentDto>>() {
        }.getType();
        return modelMapper.map(paymentRepo.getAllPayments(), type);
    }

    public StaffDto getStaffProcessedPayment(int paymentID) {
        return modelMapper.map(paymentRepo.getStaffProcessedPayment(paymentID), StaffDto.class);
    }

    public RentalDto getRentalApplied(int paymentID) {
        return modelMapper.map(paymentRepo.getRentalApplied(paymentID), RentalDto.class);
    }

    public PaymentDto addPayment(PaymentDto paymentDto) {
        Payment payment = modelMapper.map(paymentDto, Payment.class);
        return modelMapper.map(paymentRepo.addPayment(payment), PaymentDto.class);
    }

    public PaymentDto updatePayment(PaymentDto paymentDto) {
        Payment payment = modelMapper.map(paymentDto, Payment.class);
        return modelMapper.map(paymentRepo.updatePayment(payment), PaymentDto.class);
    }

    public PaymentDto getLastPayment(int customerId) {
        return modelMapper.map(paymentRepo.getLastPayment(customerId), PaymentDto.class);
    }

    public Set<PaymentDto> getPaymentWithAmount(int customerID) {
        Type type = new TypeToken<Set<PaymentDto>>() {
        }.getType();
        return modelMapper.map(paymentRepo.getPaymentWithAmount(customerID), type);
    }
}
