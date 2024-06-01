package br.com.biblioteca;

import java.sql.Connection;
import java.util.List;

public abstract class AbstractRepository<T> implements CrudRepository<T> {
    protected Connection connection = DatabaseConnection.getConnection();
    
    @Override
    public abstract void save(T t);
    
    @Override
    public abstract T findById(int id);
    
    @Override
    public abstract List<T> findAll();
    
    @Override
    public abstract void update(T t);
    
    @Override
    public abstract void delete(int id);
}

