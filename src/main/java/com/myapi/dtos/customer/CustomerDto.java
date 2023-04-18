package com.myapi.dtos.customer;

import com.myapi.dtos.StoreDto;
import com.myapi.dtos.address.AddressDto;
import com.myapi.persistence.entities.customer.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * A DTO for the {@link Customer} entity
 */
@Data
@NoArgsConstructor
public class CustomerDto implements Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private AddressDto address;
    private Date createDate;
    private Date lastUpdate;
    private StoreDto storeDto;
    private Set<PaymentDto> paymentDtos;
}