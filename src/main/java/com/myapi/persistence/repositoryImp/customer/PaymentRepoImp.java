package com.myapi.persistence.repositoryImp.customer;

import com.myapi.persistence.PersistenceManager;
import com.myapi.persistence.entities.Staff;
import com.myapi.persistence.entities.customer.Customer;
import com.myapi.persistence.entities.customer.Payment;
import com.myapi.persistence.entities.customer.Rental;
import com.myapi.persistence.repository.customer.CustomerRepo;
import com.myapi.persistence.repository.customer.PaymentRepo;
import com.myapi.persistence.repository.StaffRepo;
import com.myapi.persistence.repositoryImp.BaseRepoImp;
import com.myapi.persistence.repositoryImp.StaffRepoImp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.Set;
import java.util.stream.Collectors;

public class PaymentRepoImp extends BaseRepoImp<Payment> implements PaymentRepo {
    EntityManager entityManager;

    public PaymentRepoImp() {
        entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
    }

    @Override
    public Payment getPaymentById(int paymentID) {
        return getById(paymentID);
    }

    @Override
    public Customer getCustomerPayment(int paymentID) {
        Payment payment = getPaymentById(paymentID);
        return payment.getCustomer();
    }

    @Override
    public Set<Payment> getAllPayments() {
        return getAll(new Payment());
    }

    @Override
    public Staff getStaffProcessedPayment(int paymentId) {
        Payment payment = getPaymentById(paymentId);
        return payment.getStaff();
    }

    @Override
    public Rental getRentalApplied(int paymentId) {
        Payment payment = getPaymentById(paymentId);
        return payment.getRental();
    }

    @Override
    public Payment addPayment(Payment payment) {
        StaffRepo staffRepo = new StaffRepoImp();
        CustomerRepo customerRepo = new CustomerRepoImp();
        Staff staff = staffRepo.getStaffById(payment.getStaff().getId());
        Customer customer = customerRepo.getCustomerById(payment.getCustomer().getId());
        payment.setStaff(staff);
        payment.setCustomer(customer);
        return save(payment);
    }

    @Override
    public Payment updatePayment(Payment payment) {
        StaffRepo staffRepo = new StaffRepoImp();
        CustomerRepo customerRepo = new CustomerRepoImp();
        Staff staff = staffRepo.getStaffById(payment.getStaff().getId());
        Customer customer = customerRepo.getCustomerById(payment.getCustomer().getId());
        payment.setStaff(staff);
        payment.setCustomer(customer);
        return update(payment);
    }

    @Override
    public Payment getLastPayment(int customerID) {
        String queryString = "FROM Payment p WHERE p.customer.id = :customerId ORDER BY p.paymentDate DESC";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("customerId", customerID);
        query.setMaxResults(1);
        return (Payment) query.getSingleResult();
    }

    @Override
    public Set<Payment> getPaymentWithAmount(int customerID) {
        String queryString = "SELECT p FROM Payment p WHERE p.customer.id = :customerId AND p.amount > 5";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("customerId", customerID);
        return (Set<Payment>) query.getResultStream().collect(Collectors.toSet());
    }
}
