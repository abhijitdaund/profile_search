package mtech.dissertation.profilesearch.service.api;

import java.util.List;

import mtech.dissertation.profilesearch.dto.EmployeeSkillDetailsDTO;
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
     * Gets a list of all employee skill details DTO.
     * 
     * @param empId
     *            an employee id
     * @return a list of all employee skill details DTO
     * @throws UnexpectedException
     */
    List<EmployeeSkillDetailsDTO> findAllEmpSkillDetails() throws UnexpectedException;

    /**
     * Adds a new employee skill details.
     * 
     * @param esdDTO
     *            employee skill details DTO
     * @return an employee skill details DTO added
     * @throws UnexpectedException
     */
    EmployeeSkillDetailsDTO addEmpSkillDetails(EmployeeSkillDetailsDTO esdDTO)
            throws EntityNotFoundException, UnexpectedException;
}
