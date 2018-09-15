package mtech.dissertation.profilesearch.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mtech.dissertation.profilesearch.dto.SkillDTO;
import mtech.dissertation.profilesearch.dto.mapper.SkillMapper;
import mtech.dissertation.profilesearch.entity.Skill;
import mtech.dissertation.profilesearch.exception.EntityNotFoundException;
import mtech.dissertation.profilesearch.exception.UnexpectedException;
import mtech.dissertation.profilesearch.repository.SkillRepository;
import mtech.dissertation.profilesearch.service.api.SkillService;

/**
 * Skill Service Implementation.
 * 
 * @author Abhijit.Daund
 */
@Service
public class SkillServiceImpl extends BaseServiceImpl<Skill, SkillRepository, String>
        implements
        SkillService {

    private static final Logger LOG = LoggerFactory.getLogger(SkillServiceImpl.class);

    @Autowired
    private SkillMapper skillMapper;

    /*
     * (non-Javadoc)
     * @see
     * mtech.dissertation.profilesearch.service.api.SkillService#findSkillByName(
     * java.lang.String)
     */
    @Override
    public SkillDTO findSkillByName(final String skillName) throws EntityNotFoundException, UnexpectedException {
        LOG.info("findSkillByName(): skillName: " + skillName);
        return skillMapper.toSkillDTO(repository.findSkillByName(skillName));
    }

    /*
     * (non-Javadoc)
     * @see
     * mtech.dissertation.profilesearch.service.api.SkillService#findAllSkills()
     */
    @Override
    public List<SkillDTO> findAllSkills() throws UnexpectedException {
        LOG.info("findAllSkills(): ");
        return skillMapper.toSkillDTOList(super.findAll());
    }

    /*
     * (non-Javadoc)
     * @see
     * mtech.dissertation.profilesearch.service.api.SkillService#addSkill(mtech.
     * dissertation.profilesearch.dto.SkillDTO)
     */
    @Override
    public SkillDTO addSkill(final SkillDTO skillDTO) throws UnexpectedException {
        LOG.info("addSkill(): skillName: " + skillDTO.getSkillName());
        return skillMapper.toSkillDTO(repository.save(skillMapper.toSkillEntity(skillDTO)));
    }
}
