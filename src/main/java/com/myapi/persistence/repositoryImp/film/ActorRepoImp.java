package com.myapi.persistence.repositoryImp.film;

import com.myapi.persistence.PersistenceManager;
import com.myapi.persistence.entities.Actor;
import com.myapi.persistence.entities.film.Film;
import com.myapi.persistence.repository.film.ActorRepo;
import com.myapi.persistence.repositoryImp.BaseRepoImp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.Set;
import java.util.stream.Collectors;

public class ActorRepoImp extends BaseRepoImp<Actor> implements ActorRepo {
    EntityManager entityManager;

    public ActorRepoImp() {

        entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
    }

    @Override
    public Actor getActorById(int Id) {
        return getById(Id);
    }

    @Override
    public Set<Actor> getAllActors() {
        return getAll(new Actor());
    }

    @Override
    public Actor addActor(Actor actor) {
        return save(actor);
    }

    @Override
    public Actor updateActor(Actor actor) {
        return update(actor);
    }

    @Override
    public Set<Film> getAllFilms(int actorID) {
        String queryStr = "SELECT f FROM Film f JOIN f.filmActors fa WHERE fa.actor.id = :id";
        Query q = entityManager.createQuery(queryStr);
        q.setParameter("id", actorID);
        return (Set<Film>) q.getResultStream().collect(Collectors.toSet());
    }

    @Override
    public Long  getNumberOfFilm(int actorId) {
        String queryStr = "SELECT count(f) FROM Film f JOIN f.filmActors fa WHERE fa.actor.id = :id";
        Query q = entityManager.createQuery(queryStr);
        q.setParameter("id", actorId);
        return (Long) q.getSingleResult();
    }
}
