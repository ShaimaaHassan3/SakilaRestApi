package com.myapi.dtos.customer;

import com.myapi.dtos.StaffDto;
import com.myapi.persistence.entities.customer.Payment;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * A DTO for the {@link Payment} entity
 */
@Data
@NoArgsConstructor
public class PaymentDto implements Serializable {
    private Integer id;
    private StaffDto staff;
    private RentalDto rental;
    private BigDecimal amount;
    private Date paymentDate;
    private Date lastUpdate;
    private CustomerDto customerDto;
}