package br.com.siger.siger_api.global.service;

import br.com.siger.siger_api.global.model.IGenericBaseModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Optional;

public class GenericBaseService<R extends JpaRepository<E, T>, E extends IGenericBaseModel, T extends Serializable>
        implements IGenericBaseService<E, T> {

    @Autowired
    public R repository;

    @Transactional(rollbackFor = Exception.class)
    public E create(E entity) {
        return repository.save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public E update(T id, E entity) {
        E savedEntity = findById(id);
        BeanUtils.copyProperties(entity, savedEntity,"id");
        return repository.save(savedEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(T id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public E findById(T id) {
        Optional<E> entity = repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        }
        return null;
    }

    @Transactional(readOnly = true)
    public Object findAll() {
        return repository.findAll();
    }
}
