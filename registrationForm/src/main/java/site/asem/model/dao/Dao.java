package site.asem.model.dao;

import java.util.Collection;

public interface Dao<T> {
    void create(T entity);

    T findById(long id);

    Collection<T> findAll();

    void update(T entity);

    void delete(T entity);
}
