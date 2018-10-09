package mtech.dissertation.profilesearch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mtech.dissertation.profilesearch.entity.Employee;
import mtech.dissertation.profilesearch.exception.EntityNotFoundException;
import mtech.dissertation.profilesearch.exception.UnexpectedException;

/**
 * Employee Crud Repository interface.
 * 
 * @author Abhijit.Daund
 */
@Repository
public interface EmployeeRepository
        extends
        CrudRepository<Employee, String> {

    /**
     * Finds the skill entity by name.
     * 
     * @param skillName
     *            the skill name
     * @return the skill entity
     * @throws EntityNotFoundException
     * @throws UnexpectedException
     */
    @Query("SELECT e FROM employee e WHERE (e.firstName = :firstName OR e.firstName = :lastName) "
            + "AND (e.lastName = :firstName OR e.lastName = :lastName)")
    List<Employee> findEmployeesByName(@Param("firstName") String firstName, @Param("lastName") String lastName)
            throws EntityNotFoundException, UnexpectedException;
}
