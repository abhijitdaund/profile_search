package mtech.dissertation.profilesearch.entity;

import lombok.Data;

/**
 * Employee Skill Detail entity class.
 * 
 * @author Abhijit.Daund
 */
@Data
public class EmployeeSkillDetails {

    private Employee employee;
    private Skill skill;
    private Level level;
}
