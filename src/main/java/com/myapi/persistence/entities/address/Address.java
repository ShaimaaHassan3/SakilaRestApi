package com.myapi.persistence.entities.address;

import com.myapi.persistence.entities.Staff;
import com.myapi.persistence.entities.Store;
import com.myapi.persistence.entities.customer.Customer;
import jakarta.persistence.*;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.WKBReader;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", columnDefinition = "SMALLINT UNSIGNED not null")
    private Integer id;

    @Column(name = "address", nullable = false, length = 50)
    private String address;

    @Column(name = "address2", length = 50)
    private String address2;

    @Column(name = "district", nullable = false, length = 20)
    private String district;

    @ManyToOne( optional = false)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(name = "postal_code", length = 10)
    private String postalCode;

    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "last_update", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @OneToMany(mappedBy = "address")
    private Set<Staff> staff = new LinkedHashSet<>();

    @OneToMany(mappedBy = "address")
    private Set<Store> stores = new LinkedHashSet<>();
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
    private Set<Customer> customers = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Staff> getStaff() {
        return staff;
    }

    public void setStaff(Set<Staff> staff) {
        this.staff = staff;
    }

    public Set<Store> getStores() {
        return stores;
    }

    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

//    TODO [JPA Buddy] create field to map the 'location' column
//     Available actions: Define target Java type | Uncomment as is | Remove column mapping
//    @Column(name = "location", columnDefinition = "GEOMETRY(65535) not null")
    @Column(name = "location", columnDefinition = "GEOMETRY(65535) not null")
    private byte[] location;

    public void setLocation(byte[] location) {
        this.location = location;
    }
    public byte[] getLocation() {
        return location;
    }

//    public Geometry getLocationGeometry() throws Exception {
//        WKBReader reader = new WKBReader();
//        return reader.read(location);
//    }


}