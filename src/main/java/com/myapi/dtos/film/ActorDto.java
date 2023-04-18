package com.myapi.dtos.film;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link com.myapi.persistence.entities.Actor} entity
 */
@Data
@NoArgsConstructor
public class ActorDto implements Serializable {
    private  Integer id;
    private  String firstName;
    private  String lastName;
    private  Date lastUpdate;
}