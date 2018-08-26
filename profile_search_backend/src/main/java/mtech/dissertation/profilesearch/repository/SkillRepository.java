package mtech.dissertation.profilesearch.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mtech.dissertation.profilesearch.entity.Skill;
import mtech.dissertation.profilesearch.exception.EntityNotFoundException;
import mtech.dissertation.profilesearch.exception.UnexpectedException;

/**
 * Skill Crud Repository interface.
 * 
 * @author Abhijit.Daund
 */
@Repository
public interface SkillRepository
        extends
        CrudRepository<Skill, String> {

    /**
     * Finds the skill entity by name.
     * 
     * @param skillName
     *            the skill name
     * @return the skill entity
     * @throws EntityNotFoundException
     * @throws UnexpectedException
     */
    @Query("SELECT s FROM skill s WHERE s.skillName = :skillName")
    Skill findSkillByName(@Param("skillName") String skillName) throws EntityNotFoundException, UnexpectedException;
}
