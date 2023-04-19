package com.myapi.api;

import com.myapi.dtos.customer.CustomerDto;
import com.myapi.dtos.film.CategoryDto;
import com.myapi.dtos.film.FilmDto;
import com.myapi.services.CategoryService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

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
    public CategoryDto getCategoryById(@PathParam("id") int catID, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return service.getCategoryById(catID);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("category/{name}")
    public Response getCategoryByName(@PathParam("name") String catName, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.getCategoryByName(catName)).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("categories")
    public Response getAllCategories(@Context UriInfo uriInfo) {

        GenericEntity entity = new GenericEntity<Set<CategoryDto>>(service.getAllCategories()) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).link(self.getUri(), "self").build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("category")
    public Response addCategory(CategoryDto categoryDto, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.addCategory(categoryDto)).link(self.getUri(), "self").build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("category")
    public Response updateCategory(CategoryDto categoryDto, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(service.updateCategory(categoryDto)).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("categories/films/{name}")
    public Response getFilmsByCategory(@PathParam("name") String catName, @Context UriInfo uriInfo) {
        GenericEntity entity = new GenericEntity<Set<FilmDto>>(service.getFilmsByCategory(catName)) {
        };
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok(entity).link(self.getUri(), "self").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("categories/filmsNum/{name}")
    public Response getNumberOfFilmsByCategory(@PathParam("name") String catName, @Context UriInfo uriInfo) {
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        return Response.ok("There Is " + service.getNumberOfFilmsByCategory(catName) + " In " + catName + " Category").link(self.getUri(), "self").build();
    }
}
