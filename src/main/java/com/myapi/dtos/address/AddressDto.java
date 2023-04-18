package com.myapi.dtos.address;

import com.myapi.persistence.entities.address.Address;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link Address} entity
 */
@Data
@NoArgsConstructor
public class AddressDto implements Serializable {
    private Integer id;
    private String address;
    private String address2;
    private String district;
    private CityDto city;
    private String postalCode;
    private String phone;
    private Date lastUpdate;
    private byte[] location;
}