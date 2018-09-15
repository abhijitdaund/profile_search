package mtech.dissertation.profilesearch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
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

    @Id
    @SequenceGenerator(name = "sequence_emp_skill_id_generator", sequenceName = "emp_skill_sequence", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_emp_skill_id_generator")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    @ManyToOne
    @JoinColumn(name = "skill_level_id")
    private Level level;
}
