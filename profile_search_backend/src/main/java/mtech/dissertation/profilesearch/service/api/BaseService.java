package mtech.dissertation.profilesearch.service.api;

import java.io.IOException;
import java.io.Serializable;

import javax.persistence.EntityNotFoundException;

import org.springframework.data.repository.CrudRepository;

import mtech.dissertation.profilesearch.exception.UnexpectedException;

/**
 * The base service interface for all the functional service interfaces.
 * 
 * @author Abhijit.Daund
 */
public interface BaseService<T, R extends CrudRepository<T, ID>, ID extends Serializable> {

    /**
     * Saves a given entity.
     * 
     * @param entity
     *            the entity
     * @return the saved entity
     * @throws UnexpectedException
     */
    <S extends T> S save(S entity) throws UnexpectedException;

    /**
     * Saves all given entities.
     * 
     * @param entities
     *            the entities
     * @return the saved entities
     * @throws IllegalArgumentException
     *             in case the given entity is {@literal null}.
     */
    <S extends T> Iterable<S> save(Iterable<S> entities);

    /**
     * Retrieves an entity by its id.
     * 
     * @param id
     *            the id
     * @return the entity with the given id or {@literal null} if none found
     * @throws UnexpectedException
     * @throws IOException
     * @throws Exception
     * @throws IllegalArgumentException
     *             if {@code id} is {@literal null}
     */
    T findOne(ID id) throws EntityNotFoundException, UnexpectedException, IOException, Exception;

    /**
     * Returns whether an entity with the given id exists.
     * 
     * @param id
     *            the id, must not be {@literal null}.
     * @return true if an entity with the given id exists, {@literal false}
     *         otherwise
     * @throws IllegalArgumentException
     *             if {@code id} is {@literal null}
     */
    boolean exists(ID id);

    /**
     * Returns all instances of the type.
     * 
     * @return all entities
     */
    Iterable<T> findAll();

    /**
     * Returns all instances of the type with the given IDs.
     * 
     * @param ids
     *            the ids
     * @return all the entities belongs to respective ids
     */
    Iterable<T> findAll(Iterable<ID> ids);

    /**
     * Returns the number of entities available.
     * 
     * @return the number of entities
     */
    long count();

    /**
     * Deletes the entity with the given id.
     * 
     * @param id
     *            the id must not be {@literal null}.
     * @throws IllegalArgumentException
     *             in case the given {@code id} is {@literal null}
     */
    void delete(ID id);

    /**
     * Deletes a given entity.
     * 
     * @param entity
     *            the entity
     * @throws IllegalArgumentException
     *             in case the given entity is {@literal null}.
     */
    void delete(T entity);

    /**
     * Deletes the given entities.
     * 
     * @param entities
     *            the entities
     * @throws IllegalArgumentException
     *             in case the given {@link Iterable} is {@literal null}.
     */
    void delete(Iterable<? extends T> entities);

    /**
     * Deletes all entities managed by the repository.
     */
    void deleteAll();
}
