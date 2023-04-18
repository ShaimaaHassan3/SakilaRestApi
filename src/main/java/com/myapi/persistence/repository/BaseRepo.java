package com.myapi.persistence.repository;

import java.util.Set;

public interface BaseRepo<Table> {

    public Set<Table> getAll(Table obj);
    public Table getById(int id);
    public Table save(Table obj);
    public Table update(Table obj);
    public void delete(Table obj);

}
