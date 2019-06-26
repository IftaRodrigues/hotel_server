package com.ifta.hotel_server.dao;

import com.ifta.hotel_server.model.Cadastro;

public interface DAO<T extends Cadastro> {
    T findById(long id);
    T findByField(String fieldName, Object value);
    T findByFields(String fieldNames[], Object values[]);
    boolean remove(T entity);
    void save(T entity);
}