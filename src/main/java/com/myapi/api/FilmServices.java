package com.myapi.api;

import com.myapi.dtos.film.ActorDto;
import com.myapi.dtos.film.CategoryDto;
import com.myapi.dtos.film.FilmDto;
import com.myapi.dtos.StoreDto;
import com.myapi.services.film.ProxyFilmService;
import com.myapi.services.film.FilmService;
import com.myapi.services.film.FilmServicesIn;
import com.myapi.services.util.exception.HandelException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;


import java.util.Set;

@Path("filmservices")
public class FilmServices {
    FilmService service;

    public FilmServices() {
        service = new FilmService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("films")
    public Set<FilmDto> getAllFilms() {
        FilmServicesIn serviceIn = new ProxyFilmService();
        return serviceIn.getAllFilms();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("films/{id}")
    public FilmDto getFilmById(@PathParam("id") Integer id) throws HandelException {
        return service.getFilmById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("film")
    public FilmDto saveFilm(FilmDto filmDto) throws HandelException, IllegalAccessException {
        return service.saveFilm(filmDto);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("film/{id}")
    public void deleteFilm(@PathParam("id") int id) {
        service.deleteFilm(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("film")
    public FilmDto updateFilm(FilmDto film) throws HandelException {
        return service.updateFilm(film);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("film/{name}")
    public FilmDto getFilmByName(@PathParam("name") String title) throws HandelException {
        return service.getFilmByName(title);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("films/actors/{id}")
    public Set<ActorDto> getAllFilmActorsByFilm(@PathParam("id") int filmId) {
        return service.getAllFilmActorsByFilm(filmId);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("films/release/{year}")
    public Set<FilmDto> getAllFilmsReleaseYear(@PathParam("year") Integer ReleaseYear) throws HandelException {
        return service.getAllFilmsReleaseYear(ReleaseYear);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("films/language/{language}")
    public Set<FilmDto> getAllFilmsLanguage(@PathParam("language") String languageName) {
        return service.getAllFilmsLanguage(languageName);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("films/category/{id}")
    public Set<CategoryDto> getAllFilmCategories(@PathParam("id") int filmId) {
        return service.getAllFilmCategories(filmId);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("films/store/{id}")
    public Set<StoreDto> getAllFilmStories(@PathParam("id") int filmId) {
        return service.getAllFilmStories(filmId);
    }
}
