package mtech.dissertation.profilesearch.service.api;

import java.util.List;

import mtech.dissertation.profilesearch.dto.LevelDTO;
import mtech.dissertation.profilesearch.entity.Level;
import mtech.dissertation.profilesearch.exception.UnexpectedException;
import mtech.dissertation.profilesearch.repository.LevelRepository;

/**
 * Level Service interface.
 * 
 * @author Abhijit.Daund
 */
public interface LevelService
        extends
        BaseService<Level, LevelRepository, Integer> {

    /**
     * Finds all the levels.
     * 
     * @return DTOs of all the levels
     * @throws UnexpectedException
     */
    List<LevelDTO> findAllLevels() throws UnexpectedException;
}
