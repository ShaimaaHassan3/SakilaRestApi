package com.myapi.dtos;

import com.myapi.dtos.address.AddressDto;
import com.myapi.persistence.entities.Staff;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link Staff} entity
 */
@Data
@NoArgsConstructor
public class StaffDto implements Serializable {
    private  Short id;
    private  String firstName;
    private  String lastName;
    private  AddressDto address;
//    private  byte[] picture;
    private  String email;
    private  Boolean active;
    private  String username;
    private  String password;
    private Date lastUpdate;
    private StoreDto storeStaff;
}