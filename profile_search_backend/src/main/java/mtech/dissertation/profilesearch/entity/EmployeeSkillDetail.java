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
        if (!(obj instanceof EmployeeSkillDetail))
            return false;
        final EmployeeSkillDetail other = (EmployeeSkillDetail) obj;
        if (compositeEmpSkillId == null) {
            if (other.compositeEmpSkillId != null)
                return false;
        } else if (!compositeEmpSkillId.equals(other.compositeEmpSkillId))
            return false;
        if (levelId == null) {
            if (other.levelId != null)
                return false;
        } else if (!levelId.equals(other.levelId))
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
        result = prime * result + ((compositeEmpSkillId == null) ? 0 : compositeEmpSkillId.hashCode());
        result = prime * result + ((levelId == null) ? 0 : levelId.hashCode());
        return result;
    }
}
