package mtech.dissertation.profilesearch.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mtech.dissertation.profilesearch.entity.Level;
import mtech.dissertation.profilesearch.exception.EntityNotFoundException;
import mtech.dissertation.profilesearch.exception.UnexpectedException;

/**
 * Level Crud Repository interface.
 * 
 * @author Abhijit.Daund
 */
@Repository
public interface LevelRepository
        extends
        CrudRepository<Level, Integer> {

    /**
     * Finds the level entity by name.
     * 
     * @param levelName
     *            the level name
     * @return the level entity
     * @throws EntityNotFoundException
     * @throws UnexpectedException
     */
    @Query("SELECT l FROM level l WHERE l.levelName = :levelName")
    Level findLevelByName(@Param("levelName") String levelName) throws EntityNotFoundException, UnexpectedException;
}
