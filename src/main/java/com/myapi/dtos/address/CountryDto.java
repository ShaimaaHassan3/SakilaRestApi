package com.myapi.dtos.address;

import com.myapi.persistence.entities.address.Country;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link Country} entity
 */
@Data
@NoArgsConstructor
public class CountryDto implements Serializable {
    private  Integer id;
    private  String country;
    private Date lastUpdate;
}