package mtech.dissertation.profilesearch.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mtech.dissertation.profilesearch.dto.EmployeeDTO;
import mtech.dissertation.profilesearch.dto.EmployeeSkillDetailsDTO;
import mtech.dissertation.profilesearch.dto.SkillDetailsDTO;
import mtech.dissertation.profilesearch.service.api.EmployeeSkillDetailService;

/**
 * Employee Skill Details REST Controller class.
 * 
 * @author Abhijit.Daund
 */
@RestController
@RequestMapping(value = "/empSkillDetails")
public class EmployeeSkillDetailsController {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeSkillDetailsController.class);

    @Autowired
    private EmployeeSkillDetailService empSkillDetailsService;

    /**
     * Gets a list of employee skill details DTO for given employee id.
     * 
     * @param empId
     *            an employee id
     * @return a list of employee skill details DTO
     * @throws Exception
     */
    @RequestMapping(value = "/{empId}", method = RequestMethod.GET)
    public List<EmployeeSkillDetailsDTO> getEmpSkillDetails(@PathVariable final String empId) throws Exception {
        LOG.info("getEmpSkillDetails(): empId: " + empId);
        return empSkillDetailsService.findEmployeeSkillDetails(empId);
    }

    /**
     * Gets a list of all employee skill details DTO.
     * 
     * @param empId
     *            an employee id
     * @return a list of all employee skill details DTO
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<EmployeeSkillDetailsDTO> getAllEmpSkillDetails() throws Exception {
        LOG.info("getAllEmpSkillDetails(): ");
        return empSkillDetailsService.findAllEmpSkillDetails();
    }

    /**
     * Saves employee skill details.
     * 
     * @param empId
     *            the employee id
     * @param skillDetailsDTO
     *            the skill details DTO
     * @return an employee skill details DTO
     * @throws Exception
     */
    @RequestMapping(value = "/{empId}", method = RequestMethod.POST)
    public EmployeeSkillDetailsDTO saveEmpSkillDetails(@PathVariable final String empId,
            @RequestBody final SkillDetailsDTO skillDetailsDTO) throws Exception {
        LOG.info("saveEmpSkillDetails(): empId: " + empId);
        final EmployeeSkillDetailsDTO esdDTO = new EmployeeSkillDetailsDTO();
        final EmployeeDTO empDTO = new EmployeeDTO();
        empDTO.setEmpId(empId);
        esdDTO.setEmployeeDTO(empDTO);
        esdDTO.setSkillDetailDTO(skillDetailsDTO.getSkillDetailDTOList());
        return empSkillDetailsService.saveEmpSkillDetails(esdDTO);
    }

    /**
     * Gets a list of employee DTOs who possess the given
     * skill/skill-set/skill-levels.
     * 
     * @param skillDetailsDTO
     *            the skill/skill-set/skill-levels details DTO
     * @return list of employee DTOs
     * @throws Exception
     */
    @RequestMapping(value = "findEmployeeSkillDetails", method = RequestMethod.POST)
    public List<EmployeeDTO> findEmployeeSkillDetails(@RequestBody final SkillDetailsDTO skillDetailsDTO)
            throws Exception {
        LOG.info("findEmployeeSkillDetails(): ");
        return empSkillDetailsService.findAllEmpWithSkillDetails(skillDetailsDTO);
    }
}
