package mtech.dissertation.profilesearch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private String id;

    @Column(name = "skill_name")
    private String skillName;
}
