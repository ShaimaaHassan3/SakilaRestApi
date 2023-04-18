package com.myapi.dtos.film;

import com.myapi.persistence.entities.film.Language;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link Language} entity
 */
@Data
@NoArgsConstructor
public class LanguageDto implements Serializable {
    private  Short id;
    private  String name;
    private Date lastUpdate;
}