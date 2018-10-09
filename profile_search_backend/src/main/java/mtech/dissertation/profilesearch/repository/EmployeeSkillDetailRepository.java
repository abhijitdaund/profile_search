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
 * Employee Skill Detail Crud Repository interface.
 * 
 * @author Abhijit.Daund
 */
@Repository
public interface EmployeeSkillDetailRepository
        extends
        CrudRepository<EmployeeSkillDetail, String> {

    /**
     * Finds a list of employee skill detail by given employee id.
     * 
     * @param empId
     *            an employee id
     * @return a list of employee skill detail
     */
    @Query("SELECT sd FROM employeeskilldetail sd WHERE sd.compositeEmpSkillId.empId = :empId")
    List<EmployeeSkillDetail> findSkillDetailsByEmpId(@Param("empId") String empId)
            throws EntityNotFoundException, UnexpectedException;

    /**
     * Finds a list of employee skill detail by given skill.
     * 
     * @param skillName
     *            a skill name
     * @return a list of employee skill detail
     */
    @Query("SELECT sd FROM employeeskilldetail sd, skill s WHERE s.skillName = :skillName "
            + "AND sd.compositeEmpSkillId.skillId = s.id")
    List<EmployeeSkillDetail> findSkillDetailsBySkillName(@Param("skillName") String skillName)
            throws EntityNotFoundException, UnexpectedException;

    /**
     * Finds a list of employee skill detail by given skill and level.
     * 
     * @param skillName
     *            a skill name
     * @param levelName
     *            a level name
     * @return a list of employee skill detail
     */
    @Query("SELECT DISTINCT sd FROM employeeskilldetail sd, skill s, level l " + "WHERE s.skillName = :skillName "
            + "AND sd.compositeEmpSkillId.skillId = s.id " + "AND l.levelName = :levelName AND sd.levelId = l.id "
            + "group by sd.compositeEmpSkillId.empId")
    List<EmployeeSkillDetail> findSkillDetailsBySkillAndLevel(@Param("skillName") String skillName,
            @Param("levelName") String levelName) throws EntityNotFoundException, UnexpectedException;
}
