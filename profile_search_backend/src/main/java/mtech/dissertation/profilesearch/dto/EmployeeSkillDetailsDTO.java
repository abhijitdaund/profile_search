package mtech.dissertation.profilesearch.dto;

import java.util.List;

import lombok.Data;

/**
 * Employee Skill Details DTO class.
 * 
 * @author Abhijit.Daund
 */
@Data
public class EmployeeSkillDetailsDTO {

    private EmployeeDTO employeeDTO;
    private List<SkillDetailDTO> skillDetailDTO;
}
