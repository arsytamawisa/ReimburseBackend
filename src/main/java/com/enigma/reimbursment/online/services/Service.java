package com.enigma.reimbursment.online.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import java.util.List;

public interface Service<T,ID> {
    T save (T entity);
    T RemoveById(ID id);
    T findById(ID id);
    List<T> findAll();
    Page<T> findAll(T search, int page, int size, Direction direction);
}
