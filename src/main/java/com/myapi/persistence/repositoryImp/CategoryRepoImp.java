package com.myapi.persistence.repositoryImp;

import com.myapi.persistence.PersistenceManager;
import com.myapi.persistence.entities.film.Category;
import com.myapi.persistence.entities.film.Film;
import com.myapi.persistence.entities.film.FilmCategory;
import com.myapi.persistence.repository.CategoryRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.HashSet;
import java.util.Set;

public class CategoryRepoImp extends BaseRepoImp<Category> implements CategoryRepo {
    EntityManager entityManager;

    public CategoryRepoImp() {
        entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
    }

    @Override
    public Category getCategoryById(int catID) {
        return getById(catID);
    }

    @Override
    public Category getCategoryByName(String catName) {
        String queryString = "From Category c where c.name = : catName";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("catName", catName);
        return (Category) query.getSingleResult();
    }

    @Override
    public Set<Category> getAllCategories() {
        return getAll(new Category());
    }

    @Override
    public Category addCategory(Category category) {
        return save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return update(category);
    }

    @Override
    public Set<Film> getAllFilmsByCategory(String catNAme) {
        Category category = getCategoryByName(catNAme);
        Set<Film> films = new HashSet<>();
        for (FilmCategory filmCategory : category.getFilmCategories())
            films.add(filmCategory.getFilm());
        return films;
    }

    @Override
    public Long getNumberFilmsByCategory(String catNAme) {
        String queryStr = "SELECT COUNT(f) FROM Film f JOIN f.filmCategories c WHERE c.category.name = :catNAme";
        Query q = entityManager.createQuery(queryStr);
        q.setParameter("catNAme", catNAme);
        return (Long) q.getSingleResult();
    }
}
