package mtech.dissertation.profilesearch.service.api;

import java.util.List;

import mtech.dissertation.profilesearch.dto.EmployeeDTO;
import mtech.dissertation.profilesearch.entity.Employee;
import mtech.dissertation.profilesearch.exception.EntityNotFoundException;
import mtech.dissertation.profilesearch.exception.UnexpectedException;
import mtech.dissertation.profilesearch.repository.EmployeeRepository;

/**
 * The Employee Service interface.
 * 
 * @author Abhijit.Daund
 */
public interface EmployeeService
        extends
        BaseService<Employee, EmployeeRepository, String> {

    /**
     * Finds an employee by id.
     * 
     * @param id
     *            the id
     * @return the employee DTO
     * @throws EntityNotFoundException
     * @throws UnexpectedException
     */
    EmployeeDTO findEmployeeById(String id) throws EntityNotFoundException, UnexpectedException;

    /**
     * Finds DTOs of all the employees.
     * 
     * @return DTOs of all the employees
     * @throws UnexpectedException
     */
    List<EmployeeDTO> findAllEmployees() throws UnexpectedException;

    /**
     * Add an employee using given employee DTO.
     * 
     * @param employeeDTO
     *            the employee DTO
     * @return the employee added
     */
    EmployeeDTO addEmployee(EmployeeDTO employeeDTO) throws UnexpectedException;
}
