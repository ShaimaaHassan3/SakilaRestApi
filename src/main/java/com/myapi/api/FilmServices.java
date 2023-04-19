package com.myapi.api;

import com.myapi.dtos.customer.CustomerDto;
import com.myapi.dtos.film.ActorDto;
import com.myapi.dtos.film.CategoryDto;
import com.myapi.dtos.film.FilmDto;
import com.myapi.dtos.StoreDto;
import com.myapi.services.film.ProxyFilmService;
import com.myapi.services.film.FilmService;
import com.myapi.services.film.FilmServicesIn;
import com.myapi.services.util.exception.HandelException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;


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
    public Response getAllFilms(@Context UriInfo uriInfo) {
        FilmServicesIn serviceIn = new ProxyFilmService();
        GenericEntity entity = new GenericEntity<Set<FilmDto>>(serviceIn.getAllFilms()) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("films/{id}")
    public Response getFilmById(@PathParam("id") Integer id, @Context UriInfo uriInfo) throws HandelException {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.getFilmById(id)).link(self.getUri(), "self").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("film")
    public Response saveFilm(FilmDto filmDto, @Context UriInfo uriInfo) throws HandelException, IllegalAccessException {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.saveFilm(filmDto)).link(self.getUri(), "self").build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("film/{id}")
    public void deleteFilm(@PathParam("id") int id, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        service.deleteFilm(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("film")
    public Response updateFilm(FilmDto film, @Context UriInfo uriInfo) throws HandelException {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.updateFilm(film)).link(self.getUri(), "self").build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("film/{name}")
    public Response getFilmByName(@PathParam("name") String title, @Context UriInfo uriInfo) throws HandelException {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.getFilmByName(title)).link(self.getUri(), "self").build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("films/actors/{id}")
    public Response getAllFilmActorsByFilm(@PathParam("id") int filmId, @Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<ActorDto>>(service.getAllFilmActorsByFilm(filmId)) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).link(self.getUri(), "self").build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("films/release/{year}")
    public Response getAllFilmsReleaseYear(@PathParam("year") Integer ReleaseYear, @Context UriInfo uriInfo) throws HandelException {
        GenericEntity entity = new GenericEntity<Set<FilmDto>>(service.getAllFilmsReleaseYear(ReleaseYear)) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).link(self.getUri(), "self").build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("films/language/{language}")
    public Response getAllFilmsLanguage(@PathParam("language") String languageName, @Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<FilmDto>>(service.getAllFilmsLanguage(languageName)) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).link(self.getUri(), "self").build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("films/category/{id}")
    public Response getAllFilmCategories(@PathParam("id") int filmId, @Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<CategoryDto>>(service.getAllFilmCategories(filmId)) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).link(self.getUri(), "self").build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("films/store/{id}")
    public Response getAllFilmStories(@PathParam("id") int filmId, @Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<StoreDto>>(service.getAllFilmStories(filmId)) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).link(self.getUri(), "self").build();
    }
}
