package com.myapi.persistence.repository.film;

import com.myapi.persistence.entities.film.Language;

import java.util.Set;

public interface LanguageRepo {
    public Language getLanguageByName(String languageName);
    public Set<Language> getAllLanguage();
    public Language addLanguage(Language language);
    public Language updateLanguage(Language language);
}
