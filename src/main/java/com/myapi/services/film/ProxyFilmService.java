package com.myapi.services.film;

import com.myapi.dtos.film.FilmDto;

import java.util.Set;

public class ProxyFilmService implements FilmServicesIn {
    private FilmService realUserService;
    private Set<FilmDto> cachedFilms;

    public ProxyFilmService() {
        realUserService = new FilmService();
    }
    @Override
    public Set<FilmDto> getAllFilms() {
        if (cachedFilms == null) {
            cachedFilms = realUserService.getAllFilms();
        }
        return cachedFilms;
    }
}
