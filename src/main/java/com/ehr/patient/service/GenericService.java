package com.ehr.patient.service;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface GenericService<T extends Serializable> extends Serializable {

    T save(T t);

    List<T> findAll();

    Optional<T> getOne(Long id);
}