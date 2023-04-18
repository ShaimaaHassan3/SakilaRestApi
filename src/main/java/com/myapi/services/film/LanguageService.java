package com.myapi.services.film;

import com.google.gson.reflect.TypeToken;
import com.myapi.dtos.address.AddressDto;
import com.myapi.dtos.film.LanguageDto;
import com.myapi.persistence.entities.film.Language;
import com.myapi.persistence.repository.film.LanguageRepo;
import com.myapi.persistence.repositoryImp.film.LanguageRepoImp;
import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;
import java.util.Set;

public class LanguageService {
    LanguageRepo languageRepo;
    ModelMapper modelMapper;

    public LanguageService() {
        languageRepo = new LanguageRepoImp();
        modelMapper = new ModelMapper();
    }

    public LanguageDto getLanguage(String languageName) {
        return modelMapper.map(languageRepo.getLanguageByName(languageName), LanguageDto.class);
    }

    public Set<LanguageDto> getAllLanguage() {
        Type type = new TypeToken<Set<LanguageDto>>() {
        }.getType();
        return modelMapper.map(languageRepo.getAllLanguage(), type);
    }

    public LanguageDto addLanguage(LanguageDto languageDto) {
        Language language = modelMapper.map(languageDto, Language.class);
        return modelMapper.map(languageRepo.addLanguage(language), LanguageDto.class);
    }
    public LanguageDto updateLanguage(LanguageDto languageDto) {
        Language language = modelMapper.map(languageDto, Language.class);
        return modelMapper.map(languageRepo.updateLanguage(language), LanguageDto.class);
    }
}
