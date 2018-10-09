package mtech.dissertation.profilesearch.service.api;

import java.util.List;

import mtech.dissertation.profilesearch.dto.EmployeeDTO;
import mtech.dissertation.profilesearch.dto.EmployeeSkillDetailsDTO;
import mtech.dissertation.profilesearch.dto.SkillDetailsDTO;
import mtech.dissertation.profilesearch.entity.EmployeeSkillDetail;
import mtech.dissertation.profilesearch.exception.EntityNotFoundException;
import mtech.dissertation.profilesearch.exception.UnexpectedException;
import mtech.dissertation.profilesearch.repository.EmployeeSkillDetailRepository;

/**
 * The Employee Skill Detail Service interface.
 * 
 * @author Abhijit.Daund
 */
public interface EmployeeSkillDetailService
        extends
        BaseService<EmployeeSkillDetail, EmployeeSkillDetailRepository, String> {

    /**
     * Finds a list of employee skill details DTO for given employee id.
     * 
     * @param empId
     *            an employee id
     * @return a list of employee skill details DTO
     * @throws EntityNotFoundException
     * @throws UnexpectedException
     */
    List<EmployeeSkillDetailsDTO> findEmployeeSkillDetails(String empId)
            throws EntityNotFoundException, UnexpectedException;

    /**
     * Finds a list of all employee skill details DTO.
     * 
     * @param empId
     *            an employee id
     * @return a list of all employee skill details DTO
     * @throws UnexpectedException
     */
    List<EmployeeSkillDetailsDTO> findAllEmpSkillDetails() throws UnexpectedException;

    /**
     * Saves employee skill details.
     * 
     * @param esdDTO
     *            employee skill details DTO
     * @return an employee skill details DTO
     * @throws UnexpectedException
     */
    EmployeeSkillDetailsDTO saveEmpSkillDetails(EmployeeSkillDetailsDTO esdDTO)
            throws EntityNotFoundException, UnexpectedException;

    /**
     * Finds a list of all employee DTOs who possess the given
     * skill/skill-set/skill-levels.
     * 
     * @param skillDetailsDTO
     *            the skill/skill-set/skill-levels details DTO
     * @return a list of all employee skill details DTO
     * @throws EntityNotFoundException
     * @throws UnexpectedException
     */
    List<EmployeeDTO> findAllEmpWithSkillDetails(SkillDetailsDTO skillDetailsDTO)
            throws EntityNotFoundException, UnexpectedException;
}
