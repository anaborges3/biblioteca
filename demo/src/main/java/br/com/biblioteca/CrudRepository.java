package br.com.biblioteca;

import java.util.List;

public interface CrudRepository<T> {
    void save(T t);
    T findById(int id);
    List<T> findAll();
    void update(T t);
    void delete(int id);
}

