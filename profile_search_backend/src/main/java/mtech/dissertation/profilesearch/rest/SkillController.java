package mtech.dissertation.profilesearch.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mtech.dissertation.profilesearch.dto.SkillDTO;
import mtech.dissertation.profilesearch.service.api.SkillService;

/**
 * Skill REST Controller class.
 * 
 * @author Abhijit.Daund
 */
@RestController
@RequestMapping(value = "/skill")
public class SkillController {

    private static final Logger LOG = LoggerFactory.getLogger(SkillController.class);

    @Autowired
    private SkillService skillService;

    /**
     * Gets the list of all skill DTOs.
     * 
     * @return the list of all skill DTOs
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<SkillDTO> getSkills() throws Exception {
        LOG.info("getSkills(): ");
        return skillService.findAllSkills();
    }

    /**
     * Gets the skill DTO by name
     * 
     * @param skillName
     *            the skill name
     * @return the skill DTO
     * @throws Exception
     */
    @RequestMapping(value = "/skillByName/{skillName}", method = RequestMethod.GET)
    public SkillDTO getSkillByName(@PathVariable final String skillName) throws Exception {
        LOG.info("getSkillByName(): skillName: " + skillName);
        return skillService.findSkillByName(skillName);
    }

    /**
     * Adds a new skill.
     * 
     * @param skillDTO
     *            a skill DTO
     * @return the skill DTO
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST)
    public SkillDTO addSkill(final SkillDTO skillDTO) throws Exception {
        LOG.info("addSkill(): ");
        return skillService.addSkill(skillDTO);
    }
}
