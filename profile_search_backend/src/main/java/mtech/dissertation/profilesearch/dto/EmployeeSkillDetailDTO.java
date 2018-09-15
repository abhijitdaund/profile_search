package mtech.dissertation.profilesearch.dto;

import lombok.Data;

/**
 * Employee Skill Detail DTO class.
 * 
 * @author Abhijit.Daund
 */
@Data
public class EmployeeSkillDetailDTO {

    private EmployeeDTO employeeDTO;
    private SkillDTO skillDTO;
    private LevelDTO levelDTO;
}
