package com.myapi.api;

import com.myapi.dtos.InventoryDto;
import com.myapi.dtos.film.LanguageDto;
import com.myapi.services.film.LanguageService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.Set;

@Path("languagesrvices")
public class LanguageServices {
    LanguageService service;

    public LanguageServices() {
        service = new LanguageService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("languages/{id}")
    public Response getLanguage(@PathParam("id") String languageName, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.getLanguage(languageName)).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("languages")
    public Response getAllLanguage(@Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<LanguageDto>>(service.getAllLanguage()) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).link(self.getUri(), "self").build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("language")
    public Response addLanguage(LanguageDto languageDto, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.addLanguage(languageDto)).link(self.getUri(), "self").build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("language")
    public Response updateLanguage(LanguageDto languageDto, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.updateLanguage(languageDto)).link(self.getUri(), "self").build();
    }
}
