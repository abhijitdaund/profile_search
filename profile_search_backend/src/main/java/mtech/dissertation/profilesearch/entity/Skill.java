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

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Skill))
            return false;
        final Skill other = (Skill) obj;
        if (id != other.id)
            return false;
        return true;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
}
