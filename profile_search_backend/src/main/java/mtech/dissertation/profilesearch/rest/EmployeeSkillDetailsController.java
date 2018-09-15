package mtech.dissertation.profilesearch.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mtech.dissertation.profilesearch.dto.EmployeeSkillDetailsDTO;
import mtech.dissertation.profilesearch.service.api.EmployeeSkillDetailsService;

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
    private EmployeeSkillDetailsService empSkillDetailsService;

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
}
