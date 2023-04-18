package com.myapi.services.film;

import com.google.gson.reflect.TypeToken;
import com.myapi.dtos.film.ActorDto;
import com.myapi.dtos.film.CategoryDto;
import com.myapi.dtos.film.FilmDto;
import com.myapi.dtos.StoreDto;
import com.myapi.persistence.entities.*;
import com.myapi.persistence.entities.film.Film;
import com.myapi.persistence.entities.film.FilmActor;
import com.myapi.persistence.entities.film.FilmCategory;
import com.myapi.persistence.entities.film.Language;
import com.myapi.persistence.repository.film.FilmRepo;
import com.myapi.persistence.repositoryImp.film.FilmRepoImp;
import com.myapi.persistence.repositoryImp.film.LanguageRepoImp;
import com.myapi.services.util.exception.HandelException;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class FilmService implements FilmServicesIn {
    ModelMapper modelMapper;
    FilmRepo filmRepo;

    public FilmService() {
        modelMapper = new ModelMapper();
        filmRepo = new FilmRepoImp();
    }

    public Set<FilmDto> getAllFilms() {
        Type type = new TypeToken<Set<FilmDto>>() {
        }.getType();
        return modelMapper.map(filmRepo.getAllFilms(), type);
    }

    public FilmDto getFilmById(int id) throws HandelException {
        FilmDto filmDto;
        try {
            Film filmDto1 = filmRepo.getFilmById(id);
            if (filmDto1 == null)
                throw new HandelException("Sorry But This Film Out Of Store");
            filmDto = modelMapper.map(filmRepo.getFilmById(id), FilmDto.class);
            return filmDto;
        } catch (NullPointerException e) {
            throw new HandelException("Sorry But This Film Out Of Store");
        }

    }

    public FilmDto saveFilm(FilmDto filmDto) throws HandelException, IllegalAccessException {
        LanguageRepoImp languageRepo = new LanguageRepoImp();
        Language language = languageRepo.getLanguageById(filmDto.getLanguage().getId());
        System.out.println("language" + language);
        if (language == null)
            throw new HandelException("Sorry But This Language did not Exist");
        return modelMapper.map(filmRepo.saveFilm(modelMapper.map(filmDto, Film.class)), FilmDto.class);
    }

    public void deleteFilm(int id) {
        filmRepo.deleteFilm(id);
    }

    public FilmDto updateFilm(FilmDto film) throws HandelException {
        LanguageRepoImp languageRepo = new LanguageRepoImp();
        Language language = languageRepo.getLanguageById(film.getLanguage().getId());
        System.out.println("language" + language);
        if (language == null)
            throw new HandelException("Sorry But This Language did not Exist");
        return modelMapper.map(filmRepo.updateFilm(modelMapper.map(film, Film.class)), FilmDto.class);
    }

    public FilmDto getFilmByName(String title) throws HandelException {
        Film film = filmRepo.getFilmByName(title);
        if (film == null)
            throw new HandelException("Sorry But This Film Out Of Store");
        return modelMapper.map(filmRepo.getFilmByName(title), FilmDto.class);
    }

    public Set<ActorDto> getAllFilmActorsByFilm(int filmId) {
        Film film = filmRepo.getFilmById(filmId);
        Set<ActorDto> actorDtos = new HashSet<>();
        for (FilmActor filmActor : film.getFilmActors())
            actorDtos.add(modelMapper.map(filmActor.getActor(), ActorDto.class));
        return actorDtos;
    }

    public Set<FilmDto> getAllFilmsReleaseYear(Integer ReleaseYear) throws HandelException {
        Type type = new TypeToken<Set<FilmDto>>() {
        }.getType();
        return modelMapper.map(filmRepo.getAllFimInReleaseYear(ReleaseYear), type);
    }

    public Set<FilmDto> getAllFilmsLanguage(String languageName) {
        Type type = new TypeToken<Set<FilmDto>>() {
        }.getType();
        return modelMapper.map(filmRepo.getAllFilmsWithLanguage(languageName), type);
    }

    public Set<CategoryDto> getAllFilmCategories(int filmId) {
        Film film = filmRepo.getFilmById(filmId);
        Set<CategoryDto> actorDtos = new HashSet<>();
        for (FilmCategory categoryDto : film.getFilmCategories())
            actorDtos.add(modelMapper.map(categoryDto.getCategory(), CategoryDto.class));
        return actorDtos;
    }

    public Set<StoreDto> getAllFilmStories(int filmId) {
        Film film = filmRepo.getFilmById(filmId);
        Set<StoreDto> storeDtos = new HashSet<>();
        for (Inventory inventory : film.getInventories())
            storeDtos.add(modelMapper.map(inventory.getStore(), StoreDto.class));
        return storeDtos;
    }
}
