package com.myapi.dtos;

import com.myapi.dtos.InventoryDto;
import com.myapi.dtos.StaffDto;
import com.myapi.dtos.address.AddressDto;
import com.myapi.dtos.customer.CustomerDto;
import com.myapi.persistence.entities.Store;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * A DTO for the {@link Store} entity
 */
@Data
@NoArgsConstructor
public class StoreDetailDto implements Serializable {
    private  Short id;
    private  StaffDto managerStaff;
    private  AddressDto address;
    private  Date lastUpdate;
//    private  Set<InventoryDto> inventories;
//    private  Set<StaffDto> staff;
//    private  Set<CustomerDto> customers;
}