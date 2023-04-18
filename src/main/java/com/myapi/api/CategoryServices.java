package com.myapi.api;

import com.myapi.dtos.film.CategoryDto;
import com.myapi.dtos.film.FilmDto;
import com.myapi.services.CategoryService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.Set;

@Path("categoryservices")
public class CategoryServices {
    CategoryService service;

    public CategoryServices() {
        service = new CategoryService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("categories/{id}")
    public CategoryDto getCategoryById(@PathParam("id") int catID) {
        return service.getCategoryById(catID);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("category/{name}")
    public CategoryDto getCategoryByName(@PathParam("name") String catName) {
        return service.getCategoryByName(catName);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("categories")
    public Set<CategoryDto> getAllCategories() {
        return service.getAllCategories();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("category")
    public CategoryDto addCategory(CategoryDto categoryDto) {
        return service.addCategory(categoryDto);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("category")
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        return service.updateCategory(categoryDto);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("categories/films/{name}")
    public Set<FilmDto> getFilmsByCategory(@PathParam("name") String catName) {
        return service.getFilmsByCategory(catName);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("categories/filmsNum/{name}")
    public String getNumberOfFilmsByCategory(@PathParam("name") String catName) {
        return "There Is " + service.getNumberOfFilmsByCategory(catName) + " In " + catName + " Category";
    }
}
