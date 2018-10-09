package mtech.dissertation.profilesearch.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mtech.dissertation.profilesearch.dto.LevelDTO;
import mtech.dissertation.profilesearch.dto.mapper.LevelMapper;
import mtech.dissertation.profilesearch.entity.Level;
import mtech.dissertation.profilesearch.exception.UnexpectedException;
import mtech.dissertation.profilesearch.repository.LevelRepository;
import mtech.dissertation.profilesearch.service.api.LevelService;

/**
 * Level Service Implementation.
 * 
 * @author Abhijit.Daund
 */
@Service
public class LevelServiceImpl extends BaseServiceImpl<Level, LevelRepository, Integer>
        implements
        LevelService {

    private static final Logger LOG = LoggerFactory.getLogger(LevelServiceImpl.class);

    @Autowired
    private LevelMapper levelMapper;

    /*
     * (non-Javadoc)
     * @see
     * mtech.dissertation.profilesearch.service.api.LevelService#findAllLevels()
     */
    @Override
    public List<LevelDTO> findAllLevels() throws UnexpectedException {
        LOG.info("findAllLevels(): ");
        return levelMapper.toLevelDTOList(super.findAll());
    }
}
