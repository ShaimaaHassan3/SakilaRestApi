package com.myapi.api;

import com.myapi.dtos.film.ActorDto;
import com.myapi.dtos.film.FilmDto;
import com.myapi.services.film.ActorService;
import jakarta.jws.WebMethod;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.Set;

@Path("actorservices")
public class ActorServices {
    ActorService service;

    public ActorServices() {
        service = new ActorService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("actors/{id}")
    public ActorDto getActor(@PathParam("id") int ID) {
        return service.getActorById(ID);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("actors")
    public Set<ActorDto> getAllActors() {
        return service.getAllActors();
    }

    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("actor")
    public ActorDto addActor(ActorDto actorDto) {
        return service.addActor(actorDto);
    }

    @PUT
    @Path("actor")
    @Consumes(MediaType.APPLICATION_JSON)
    public ActorDto updateActor(ActorDto actorDto) {
        return service.updateActor(actorDto);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("films/{id}")
    public Set<FilmDto> getAllFilms(@PathParam("id") int ID) {
        return service.getFilms(ID);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("filmsNum/{id}")
    public String getNumberFilmOfActor(@PathParam("id") int actorId) {
        return "Number Of Films For This Actor " + service.getNumberFilmOfActor(actorId);
    }
}

