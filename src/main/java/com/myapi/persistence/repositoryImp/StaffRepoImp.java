package com.myapi.persistence.repositoryImp;

import com.myapi.persistence.PersistenceManager;
import com.myapi.persistence.entities.Staff;
import com.myapi.persistence.entities.Store;
import com.myapi.persistence.entities.address.Address;
import com.myapi.persistence.entities.customer.Payment;
import com.myapi.persistence.entities.customer.Rental;
import com.myapi.persistence.repository.address.AddressRepo;
import com.myapi.persistence.repository.StaffRepo;
import com.myapi.persistence.repository.StoreRepo;
import com.myapi.persistence.repositoryImp.address.AddressRepoImp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.Set;
import java.util.stream.Collectors;

public class StaffRepoImp extends BaseRepoImp<Staff> implements StaffRepo {
    EntityManager entityManager;

    public StaffRepoImp() {
        entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
    }

    @Override
    public Set<Staff> getAllStaff() {
        return getAll(new Staff());
    }

    @Override
    public Staff getStaffById(int ID) {
        return getById(ID);
    }

    @Override
    public Staff addStaff(Staff staff) {
        AddressRepo addressRepo = new AddressRepoImp();
        StoreRepo storeRepo = new StoreRepoImp();
        Address address = addressRepo.getAddressById(staff.getAddress().getId());
        Store store = storeRepo.getStoreById(staff.getStore().getId());
        staff.setStore(store);
        staff.setAddress(address);
        return save(staff);
    }

    @Override
    public Staff updateStaff(Staff staff) {
        AddressRepo addressRepo = new AddressRepoImp();
        StoreRepo storeRepo = new StoreRepoImp();
        Address address = addressRepo.getAddressById(staff.getAddress().getId());
        Store store = storeRepo.getStoreById(staff.getStore().getId());
        staff.setStore(store);
        staff.setAddress(address);
        return update(staff);
    }

    @Override
    public Staff getStaffByName(String fName, String lName) {
        String quaryString = "from Staff s where s.firstName = :fName and s.lastName = :lName";
        Query query = entityManager.createQuery(quaryString);
        query.setParameter("fName", fName);
        query.setParameter("lName", lName);
        return (Staff) query.getSingleResult();
    }

    @Override
    public Set<Rental> getAllRentalByStaff(int staffID){
        String quaryString = "SELECT r FROM Rental r WHERE r.staff.id = :staffId";
        Query query = entityManager.createQuery(quaryString);
        query.setParameter("staffId", staffID);
        query.setMaxResults(10);
        return (Set<Rental>) query.getResultStream().collect(Collectors.toSet());
    }

    @Override
    public Set<Payment> getAllPaymentByStaff(int staffID) {
        String quaryString = "SELECT p FROM Payment p WHERE p.staff.id = :staffId";
        Query query = entityManager.createQuery(quaryString);
        query.setParameter("staffId", staffID);
        query.setMaxResults(10);
        return (Set<Payment>) query.getResultStream().collect(Collectors.toSet());
    }

}
