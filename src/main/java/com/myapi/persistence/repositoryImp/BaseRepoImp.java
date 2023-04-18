package com.myapi.persistence.repositoryImp;

import com.myapi.persistence.PersistenceManager;
import com.myapi.persistence.repository.BaseRepo;
import jakarta.persistence.*;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseRepoImp<Table> implements BaseRepo<Table> {

    private EntityManager entityManager;
    private Class<Table> type;

    public BaseRepoImp() {
        entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
        //Detect class of Table
        Type genericSuperclass = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        this.type = (Class<Table>) parameterizedType.getActualTypeArguments()[0];
    }

    @Override
    public Set<Table> getAll(Table obj) {
        String jpql = "SELECT o FROM " + obj.getClass().getSimpleName() + " o";
        Query query = entityManager.createQuery(jpql, List.class);
        return (Set<Table>) query.getResultStream().collect(Collectors.toSet());
    }

    @Override
    public Table getById(int id) {
        Table table = (Table) entityManager.find(type, id);
        return table;
    }

    @Override
    public Table save(Table obj) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(obj);
            transaction.commit();
        } catch (PersistenceException e) {
            System.out.println("Persistence Error in Base");
//            response.getWriter().write("{error: true}");
            e.printStackTrace();
            throw new PersistenceException();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public Table update(Table obj) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(obj);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public void delete(Table obj) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(obj);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }
}
