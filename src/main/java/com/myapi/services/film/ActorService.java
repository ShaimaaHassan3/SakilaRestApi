package com.myapi.services.film;

import com.google.gson.reflect.TypeToken;
import com.myapi.dtos.film.ActorDto;
import com.myapi.dtos.film.FilmDto;
import com.myapi.persistence.entities.Actor;
import com.myapi.persistence.repository.film.ActorRepo;
import com.myapi.persistence.repositoryImp.film.ActorRepoImp;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;
import java.util.Set;

public class ActorService {
    ActorRepo actorRepo;
    ModelMapper modelMapper;

    public ActorService() {
        actorRepo = new ActorRepoImp();
        modelMapper = new ModelMapper();
    }

    public ActorDto getActorById(int ID) {
        return modelMapper.map(actorRepo.getActorById(ID), ActorDto.class);
    }

    public Set<ActorDto> getAllActors() {
        Type type = new TypeToken<Set<ActorDto>>() {
        }.getType();
        return modelMapper.map(actorRepo.getAllActors(), type);
    }

    public ActorDto addActor(ActorDto actorDto) {
        Actor actor = modelMapper.map(actorDto, Actor.class);
        return modelMapper.map(actorRepo.addActor(actor), ActorDto.class);
    }

    public ActorDto updateActor(ActorDto actorDto) {
        Actor actor = modelMapper.map(actorDto, Actor.class);
        return modelMapper.map(actorRepo.updateActor(actor), ActorDto.class);
    }
    public Set<FilmDto> getFilms(int actorID) {
        Type type = new TypeToken<Set<FilmDto>>() {
        }.getType();
        return modelMapper.map(actorRepo.getAllFilms(actorID), type);
    }
    public Long  getNumberFilmOfActor(int actorId) {
        return actorRepo.getNumberOfFilm(actorId);
    }
}
