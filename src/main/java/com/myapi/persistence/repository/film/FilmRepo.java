package com.myapi.persistence.repository.film;

import com.myapi.persistence.entities.film.Film;
import com.myapi.persistence.entities.film.FilmActor;

import java.util.Set;

public interface FilmRepo {
    public Set<Film> getAllFilms();
    public Film getFilmById(int id);
    public Film saveFilm(Film film);
    public void deleteFilm(int id);
    public Film updateFilm(Film film);
    public Film getFilmByName(String Name);
    public Set<FilmActor> getAllFilmActorsByFilm(int filmId);
    public Set<Film> getAllFimInReleaseYear(Integer ReleaseYear);
    public Set<Film> getAllFilmsWithLanguage(String languageName);
}

