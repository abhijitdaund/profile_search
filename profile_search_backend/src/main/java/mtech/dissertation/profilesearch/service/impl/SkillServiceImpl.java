package mtech.dissertation.profilesearch.service.impl;

import org.springframework.stereotype.Service;

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

    /*
     * (non-Javadoc)
     * @see
     * mtech.dissertation.profilesearch.service.api.SkillService#getSkillByName(java
     * .lang.String)
     */
    @Override
    public Skill getSkillByName(final String skillName) throws UnexpectedException, EntityNotFoundException {
        return repository.findSkillByName(skillName);
    }
}
