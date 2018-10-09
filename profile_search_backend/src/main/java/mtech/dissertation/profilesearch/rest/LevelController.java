package mtech.dissertation.profilesearch.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mtech.dissertation.profilesearch.dto.LevelDTO;
import mtech.dissertation.profilesearch.service.api.LevelService;

/**
 * Level REST Controller class.
 * 
 * @author Abhijit.Daund
 */
@RestController
@RequestMapping(value = "/level")
public class LevelController {

    private static final Logger LOG = LoggerFactory.getLogger(LevelController.class);

    @Autowired
    private LevelService levelService;

    /**
     * Gets the list of all skill DTOs.
     * 
     * @return the list of all skill DTOs
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<LevelDTO> getLevels() throws Exception {
        LOG.info("getLevels(): ");
        return levelService.findAllLevels();
    }
}
