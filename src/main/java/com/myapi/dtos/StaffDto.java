package com.myapi.dtos;

import com.myapi.dtos.address.AddressDto;
import com.myapi.persistence.entities.Staff;
import jakarta.ws.rs.core.Link;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    List<Link> links = new ArrayList<>();
}