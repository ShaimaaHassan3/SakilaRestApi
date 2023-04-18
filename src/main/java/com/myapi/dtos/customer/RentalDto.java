package com.myapi.dtos.customer;

import com.myapi.dtos.InventoryDto;
import com.myapi.dtos.StaffDto;
import com.myapi.persistence.entities.customer.Rental;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link Rental} entity
 */
@Data
@NoArgsConstructor
public class RentalDto implements Serializable {
    private Integer id;
    private Date rentalDate;
    private InventoryDto inventory;
    private Date returnDate;
    private Date lastUpdate;
    private CustomerDto customerDto;
    private StaffDto staffDto;
}