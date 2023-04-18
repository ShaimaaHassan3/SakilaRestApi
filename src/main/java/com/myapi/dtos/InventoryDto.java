package com.myapi.dtos;

import com.myapi.dtos.film.FilmDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.myapi.persistence.entities.Inventory} entity
 */
@Data
@NoArgsConstructor
public class InventoryDto implements Serializable {
    private Integer id;
    private FilmDto film;
    private  StoreDto store;
    private Date lastUpdate;
}