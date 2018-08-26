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
import mtech.dissertation.profilesearch.dto.mapper.EmployeeMapper;
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
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employeeById/{id}", method = RequestMethod.GET)
    public EmployeeDTO getEmployeeById(@PathVariable final String id) throws Exception {
        LOG.info("getEmployeeById by id: " + id);
        return employeeMapper.toEmployeeDTO(employeeService.findOne(id));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<EmployeeDTO> getEmployees() throws Exception {
        LOG.info("*** Ticket Controller : getEmployees: ");
        return employeeMapper.toEmployeeDTOList(employeeService.findAll());
    }
}
