package com.myapi.api;

import com.myapi.dtos.film.LanguageDto;
import com.myapi.services.film.LanguageService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

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
    public LanguageDto getLanguage(@PathParam("id") String languageName) {
        return service.getLanguage(languageName);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("languages")
    public Set<LanguageDto> getAllLanguage() {
        return service.getAllLanguage();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("language")
    public LanguageDto addLanguage(LanguageDto languageDto) {
        return service.addLanguage(languageDto);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("language")
    public LanguageDto updateLanguage(LanguageDto languageDto) {
        return service.updateLanguage(languageDto);
    }
}
