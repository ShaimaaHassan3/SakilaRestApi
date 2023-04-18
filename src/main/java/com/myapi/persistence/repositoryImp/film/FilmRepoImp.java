package com.myapi.persistence.repositoryImp.film;

import com.myapi.persistence.PersistenceManager;
import com.myapi.persistence.entities.*;
import com.myapi.persistence.entities.film.Film;
import com.myapi.persistence.entities.film.FilmActor;
import com.myapi.persistence.entities.film.FilmCategory;
import com.myapi.persistence.repository.film.FilmRepo;
import com.myapi.persistence.repositoryImp.BaseRepoImp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FilmRepoImp extends BaseRepoImp<Film> implements FilmRepo {
    EntityManager entityManager;

    public FilmRepoImp() {

        entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();

    }

    @Override
    public Set<Film> getAllFilms() {
        return getAll(new Film());
    }


    @Override
    public Film getFilmById(int id) {
        Film film = entityManager.find(Film.class, id);
        return film;
    }

    @Override
    public Film saveFilm(Film film) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(film);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
        return film;
    }


    @Override
    public void deleteFilm(int id) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            Film film = entityManager.find(Film.class, id);
//            film.getFilmCategories().clear();
//            film.getFilmActors().clear();
            for (FilmActor actor : film.getFilmActors()) {
                actor.setFilm(null);
                entityManager.remove(actor);
            }
            for (FilmCategory category : film.getFilmCategories()) {
                category.setFilm(null);
                entityManager.remove(category);
            }
            for (Inventory inventory : film.getInventories()) {
                inventory.setFilm(null);
                entityManager.remove(inventory);
            }
            entityManager.refresh(film);
            entityManager.remove(film);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }

    @Override
    public Film updateFilm(Film film) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.merge(film);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
        return film;
    }

    @Override
    public Film getFilmByName(String title) {
        Query query = entityManager.createQuery("SELECT f FROM Film f WHERE f.title LIKE  :title");
        query.setParameter("title", "%" + title + "%");
        List<Film> films = query.getResultList();
        return films.isEmpty() ? null : films.get(0);
    }

    @Override
    public Set<FilmActor> getAllFilmActorsByFilm(int filmId) {
        try {
            entityManager.getTransaction().begin();
            TypedQuery<FilmActor> query = entityManager.createQuery(
                    "SELECT filmActors FROM Film film WHERE film.id = :filmId", FilmActor.class);
            query.setParameter("filmId", filmId);
            Set<FilmActor> filmActors = (Set<FilmActor>) query.getResultStream().collect(Collectors.toSet());
            entityManager.getTransaction().commit();
            return filmActors;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Set<Film> getAllFimInReleaseYear(Integer ReleaseYear) {
        String quaryString = "From Film f where f.releaseYear = :ReleaseYear";
        Query query = entityManager.createQuery(quaryString);
        query.setParameter("ReleaseYear", ReleaseYear);
        return (Set<Film>) query.getResultStream().collect(Collectors.toSet());
    }

    @Override
    public Set<Film> getAllFilmsWithLanguage(String languageName) {
        System.out.println("Language Name " + languageName);
        String quaryString = "SELECT f FROM Film f JOIN f.language l WHERE l.name = :languageName";
        Query query = entityManager.createQuery(quaryString);
        query.setParameter("languageName", languageName.trim());
        return (Set<Film>) query.getResultStream().collect(Collectors.toSet());
    }

}
