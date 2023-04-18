package com.myapi;

import java.util.List;
import java.util.Set;

import com.myapi.dtos.film.ActorDto;
import com.myapi.services.film.ActorService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("myresource")
public class MyResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    ActorService service = new ActorService();

//    @Path("actors")
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getAllActors() {
//        GenericEntity en = new GenericEntity<Set<ActorDto>>(service.getAllActors()) {
//        };
//        return Response.ok().entity(en).build();
//    }


}
