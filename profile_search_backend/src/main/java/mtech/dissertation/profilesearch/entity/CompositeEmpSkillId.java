package mtech.dissertation.profilesearch.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

/**
 * Composite Id with employee id and skill id entity class.
 * 
 * @author Abhijit.Daund
 */
@Data
@Embeddable
public class CompositeEmpSkillId
        implements
        Serializable {

    private static final long serialVersionUID = 4113871439512741814L;

    @Column(name = "emp_id")
    private String empId;

    @Column(name = "skill_id")
    private Integer skillId;

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
        if (!(obj instanceof CompositeEmpSkillId))
            return false;
        final CompositeEmpSkillId other = (CompositeEmpSkillId) obj;
        if (empId == null) {
            if (other.empId != null)
                return false;
        } else if (!empId.equals(other.empId))
            return false;
        if (skillId == null) {
            if (other.skillId != null)
                return false;
        } else if (!skillId.equals(other.skillId))
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
        result = prime * result + ((empId == null) ? 0 : empId.hashCode());
        result = prime * result + ((skillId == null) ? 0 : skillId.hashCode());
        return result;
    }
}
