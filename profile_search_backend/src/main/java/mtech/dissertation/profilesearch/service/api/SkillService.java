package mtech.dissertation.profilesearch.service.api;

import mtech.dissertation.profilesearch.entity.Skill;
import mtech.dissertation.profilesearch.exception.EntityNotFoundException;
import mtech.dissertation.profilesearch.exception.UnexpectedException;
import mtech.dissertation.profilesearch.repository.SkillRepository;

/**
 * Skill Service interface.
 * 
 * @author Abhijit.Daund
 */
public interface SkillService
        extends
        BaseService<Skill, SkillRepository, String> {

    /**
     * Gets the skill entity by name.
     * 
     * @param skillName
     *            the skill name
     * @return the skill entity
     */
    Skill getSkillByName(String skillName) throws UnexpectedException, EntityNotFoundException;
}
