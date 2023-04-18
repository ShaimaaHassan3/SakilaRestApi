package com.myapi.persistence.repository.film;

import com.myapi.persistence.entities.Actor;
import com.myapi.persistence.entities.film.Film;
import org.checkerframework.checker.units.qual.A;

import java.util.Set;

public interface ActorRepo {
    Actor getActorById(int Id);
    Set<Actor> getAllActors();
    Actor addActor(Actor actor);
    Actor updateActor(Actor actor);
    Set<Film> getAllFilms(int actorID);
    Long  getNumberOfFilm(int actorId);
}
