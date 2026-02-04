package com.ndyudev.lab7.common;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseService<T, ID> {
    T save(T entity);
    void delete(ID id);
    T findById(ID id);
    List<T> findAll();
}
