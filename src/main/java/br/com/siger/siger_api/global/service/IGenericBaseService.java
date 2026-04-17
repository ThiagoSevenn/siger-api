package br.com.siger.siger_api.global.service;

import br.com.siger.siger_api.global.model.IGenericBaseModel;

public interface IGenericBaseService<E extends IGenericBaseModel, T> {

    E create(E entity);
    E update(T id, E entity);
    void delete(T id);
    E findById(T id);
    Object findAll();
}
