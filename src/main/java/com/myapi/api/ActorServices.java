package com.myapi.api;

import com.myapi.dtos.film.ActorDto;
import com.myapi.dtos.film.FilmDto;
import com.myapi.services.film.ActorService;
import jakarta.jws.WebMethod;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.List;
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
    public Response getAllActors(@Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<ActorDto>>(service.getAllActors()) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();

        return Response.ok(entity).links(self).build();
    }

    @POST()
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("actor")
    public Response addActor(ActorDto actorDto, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.addActor(actorDto)).link(self.getUri(), "self").build();
    }

    @PUT
    @Path("actor")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateActor(ActorDto actorDto, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.updateActor(actorDto)).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("films/{id}")
    public Response getAllFilms(@PathParam("id") int ID, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();

        return Response.ok(service.getFilms(ID)).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("filmsNum/{id}")
    public Response getNumberFilmOfActor(@PathParam("id") int actorId, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok("Number Of Films For This Actor " + service.getNumberFilmOfActor(actorId)).link(self.getUri(), "self").build();
    }
}

