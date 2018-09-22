package mtech.dissertation.profilesearch.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

/**
 * Employee Skill Detail entity class.
 * 
 * @author Abhijit.Daund
 */
@Data
@Entity(name = "employeeskilldetail")
@Table(name = "employee_skill")
public class EmployeeSkillDetail {

    @EmbeddedId
    private CompositeEmpSkillId compositeEmpSkillId;

    @Column(name = "skill_level_id")
    private Integer levelId;
}
