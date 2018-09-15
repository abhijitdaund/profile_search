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
 * Level entity class.
 * 
 * @author Abhijit.Daund
 */
@Data
@Entity(name = "level")
@Table(name = "skill_level_lkp")
public class Level {

    @Id
    @SequenceGenerator(name = "sequence_level_id_generator", sequenceName = "level_sequence", initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_level_id_generator")
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "level_name")
    private String levelName;
}
