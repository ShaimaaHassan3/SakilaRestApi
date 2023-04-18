package com.myapi.dtos.film;

import com.myapi.persistence.entities.film.FilmActor;
import com.myapi.persistence.entities.film.FilmActorId;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * A DTO for the {@link FilmActor} entity
 */
@Data
@NoArgsConstructor
public class FilmActorDto implements Serializable {
    private  FilmActorIdDto id;
    private ActorDto actor;
    private  Date lastUpdate;

    /**
     * A DTO for the {@link FilmActorId} entity
     */
    @Data
    @NoArgsConstructor
    public static class FilmActorIdDto implements Serializable {
        private  Integer actorId;
        private  Integer filmId;
    }
}