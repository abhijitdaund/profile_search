package mtech.dissertation.profilesearch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

/**
 * Skill entity class.
 * 
 * @author Abhijit.Daund
 */
@Data
@Entity(name = "skill")
@Table(name = "skill_lkp")
public class Skill {

    @Id
    @SequenceGenerator(name = "sequence_skill_id_generator", sequenceName = "skill_sequence", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_skill_id_generator")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "skill_name")
    private String skillName;
}
