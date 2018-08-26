package mtech.dissertation.profilesearch.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mtech.dissertation.profilesearch.entity.Employee;

/**
 * Employee Crud Repository interface.
 * 
 * @author Abhijit.Daund
 */
@Repository
public interface EmployeeRepository
        extends
        CrudRepository<Employee, String> {

}
