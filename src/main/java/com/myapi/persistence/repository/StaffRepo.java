package com.myapi.persistence.repository;

import com.myapi.persistence.entities.Staff;
import com.myapi.persistence.entities.customer.Payment;
import com.myapi.persistence.entities.customer.Rental;

import java.util.Set;

public interface StaffRepo {
    Set<Staff> getAllStaff();
    Staff getStaffById(int ID);
    Staff addStaff(Staff staff);
    Staff updateStaff(Staff staff);
    Staff getStaffByName(String fName , String lName);
    Set<Rental> getAllRentalByStaff(int staffID);
    Set<Payment> getAllPaymentByStaff(int staffID);
}
