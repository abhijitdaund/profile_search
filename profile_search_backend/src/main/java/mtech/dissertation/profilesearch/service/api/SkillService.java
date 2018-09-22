package mtech.dissertation.profilesearch.service.api;

import java.util.List;

import mtech.dissertation.profilesearch.dto.SkillDTO;
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
        BaseService<Skill, SkillRepository, Integer> {

    /**
     * Finds the skill DTO by name.
     * 
     * @param skillName
     *            the skill name
     * @return the skill DTO
     * @throws EntityNotFoundException
     * @throws UnexpectedException
     */
    SkillDTO findSkillByName(String skillName) throws EntityNotFoundException, UnexpectedException;

    /**
     * Finds DTOs of all the skill.
     * 
     * @return DTOs of all the skills
     * @throws UnexpectedException
     */
    List<SkillDTO> findAllSkills() throws UnexpectedException;

    /**
     * Add the skill using given skill DTO.
     * 
     * @param skillDTO
     *            the skill DTO
     * @return the skill added
     */
    SkillDTO addSkill(SkillDTO skillDTO) throws UnexpectedException;
}
