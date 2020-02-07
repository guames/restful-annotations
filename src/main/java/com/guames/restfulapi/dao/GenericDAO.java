package com.guames.restfulapi.dao;

import java.util.Optional;

public class GenericDAO<E> {

    private Class<E> entityClass;

    public GenericDAO(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    public String findAll() {
        return "new String();";
    }

    public Optional<E> persist(E toPersist) {
        return null;
    }
}
