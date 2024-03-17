package org.corecode.repository;

import java.sql.SQLException;
import java.util.List;

public interface IRepository <T>{

    List<T> findAll() throws SQLException;

    T getById(Integer id);

    void save(T t);

    void delete(Integer id);

    T update(Integer id, String fieldToUpdate, Object input);
}
