package com.myapi.persistence.repository.customer;

import com.myapi.persistence.entities.Staff;
import com.myapi.persistence.entities.customer.Customer;
import com.myapi.persistence.entities.customer.Payment;
import com.myapi.persistence.entities.customer.Rental;

import java.util.Set;

public interface PaymentRepo {
    public Payment getPaymentById(int paymentID);
    public Customer getCustomerPayment(int paymentID);
    public Set<Payment> getAllPayments();
    public Staff getStaffProcessedPayment(int paymentId);
    public Rental getRentalApplied(int paymentId);
    public Payment addPayment(Payment payment);
    public Payment updatePayment(Payment payment);
    public Payment getLastPayment(int customerID);
    public Set<Payment> getPaymentWithAmount(int customerID);

}
