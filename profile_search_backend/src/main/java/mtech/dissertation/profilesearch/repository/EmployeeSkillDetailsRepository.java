package mtech.dissertation.profilesearch.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mtech.dissertation.profilesearch.entity.EmployeeSkillDetail;
import mtech.dissertation.profilesearch.exception.EntityNotFoundException;
import mtech.dissertation.profilesearch.exception.UnexpectedException;

/**
 * Employee Skill Details Crud Repository interface.
 * 
 * @author Abhijit.Daund
 */
@Repository
public interface EmployeeSkillDetailsRepository
        extends
        CrudRepository<EmployeeSkillDetail, String> {

    /**
     * Finds a list of employee skill detail for given employee id.
     * 
     * @param empId
     *            an employee id
     * @return a list of employee skill detail
     */
    @Query("SELECT sd FROM employee e, employeeskilldetail sd, skill s, level l WHERE e.empId = :empId and "
            + "sd.employee.empId = :empId and s.id = sd.skill.id and l.id = sd.level.id")
    List<EmployeeSkillDetail> findEmployeeSkillDetails(@Param("empId") String empId)
            throws EntityNotFoundException, UnexpectedException;
}
