package com.myapi.dtos.film;

import com.myapi.persistence.entities.film.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link Category} entity
 */
@Data
@NoArgsConstructor
public class CategoryDto implements Serializable {
    private  Short id;
    private  String name;
    private  Date lastUpdate;
}