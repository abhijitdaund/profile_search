package mtech.dissertation.profilesearch.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mtech.dissertation.profilesearch.dto.EmployeeDTO;
import mtech.dissertation.profilesearch.service.api.EmployeeService;

/**
 * Employee REST Controller class.
 * 
 * @author Abhijit.Daund
 */
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    /**
     * Gets the list of all employee DTOs.
     * 
     * @return the list of all employee DTOs
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<EmployeeDTO> getEmployees() throws Exception {
        LOG.info("getEmployees(): ");
        return employeeService.findAllEmployees();
    }

    /**
     * Gets the employee DTO by given id.
     * 
     * @param id
     *            the id
     * @return the employee DTO
     * @throws Exception
     */
    @RequestMapping(value = "/employeeById/{id}", method = RequestMethod.GET)
    public EmployeeDTO getEmployeeById(@PathVariable final String id) throws Exception {
        LOG.info("getEmployeeById(): id: " + id);
        return employeeService.findEmployeeById(id);
    }

    /**
     * Adds a new employee.
     * 
     * @param empDTO
     *            an employee DTO
     * @return the employee DTO
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST)
    public EmployeeDTO addEmployee(final EmployeeDTO empDTO) throws Exception {
        LOG.info("addEmployee(): ");
        return employeeService.addEmployee(empDTO);
    }
}
