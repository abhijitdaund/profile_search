package mtech.dissertation.profilesearch.service.impl;

import java.io.IOException;
import java.io.Serializable;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import mtech.dissertation.profilesearch.exception.UnexpectedException;
import mtech.dissertation.profilesearch.service.api.BaseService;

/**
 * Abstract class implements all basic CRUD methods from BaseService for the
 * given template.
 * 
 * @author Abhijit.Daund
 * @param <T>
 * @param <R>
 * @param <ID>
 */
@Transactional
public abstract class BaseServiceImpl<T, R extends CrudRepository<T, ID>, ID extends Serializable>
        implements
        BaseService<T, R, ID> {

    @Autowired
    R repository;

    /*
     * (non-Javadoc)
     * @see mtech.dissertation.profilesearch.service.api.BaseService#save(java.lang.
     * Object)
     */
    @Override
    @Transactional()
    public <S extends T> S save(final S entity) throws UnexpectedException {
        return repository.save(entity);
    }

    /*
     * (non-Javadoc)
     * @see mtech.dissertation.profilesearch.service.api.BaseService#save(java.lang.
     * Iterable)
     */
    @Override
    public <S extends T> Iterable<S> save(final Iterable<S> entities) {
        return repository.save(entities);
    }

    /*
     * (non-Javadoc)
     * @see
     * mtech.dissertation.profilesearch.service.api.BaseService#findOne(java.io.
     * Serializable)
     */
    @Override
    public T findOne(final ID id) throws EntityNotFoundException, IOException, Exception {
        return repository.findOne(id);
    }

    /*
     * (non-Javadoc)
     * @see mtech.dissertation.profilesearch.service.api.BaseService#exists(java.io.
     * Serializable)
     */
    @Override
    public boolean exists(final ID id) {
        return repository.exists(id);
    }

    /*
     * (non-Javadoc)
     * @see mtech.dissertation.profilesearch.service.api.BaseService#findAll()
     */
    @Override
    public Iterable<T> findAll() {
        return repository.findAll();
    }

    /*
     * (non-Javadoc)
     * @see
     * mtech.dissertation.profilesearch.service.api.BaseService#findAll(java.lang.
     * Iterable)
     */
    @Override
    public Iterable<T> findAll(final Iterable<ID> ids) {
        return repository.findAll();
    }

    /*
     * (non-Javadoc)
     * @see mtech.dissertation.profilesearch.service.api.BaseService#count()
     */
    @Override
    public long count() {
        return repository.count();
    }

    /*
     * (non-Javadoc)
     * @see mtech.dissertation.profilesearch.service.api.BaseService#delete(java.io.
     * Serializable)
     */
    @Override
    public void delete(final ID id) {
        repository.delete(id);
    }

    /*
     * (non-Javadoc)
     * @see
     * mtech.dissertation.profilesearch.service.api.BaseService#delete(java.lang.
     * Object)
     */
    @Override
    public void delete(final T entity) {
        repository.delete(entity);
    }

    /*
     * (non-Javadoc)
     * @see
     * mtech.dissertation.profilesearch.service.api.BaseService#delete(java.lang.
     * Iterable)
     */
    @Override
    public void delete(final Iterable<? extends T> entities) {
        repository.delete(entities);
    }

    /*
     * (non-Javadoc)
     * @see mtech.dissertation.profilesearch.service.api.BaseService#deleteAll()
     */
    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
