package mtech.dissertation.profilesearch.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * Employee entity class.
 * 
 * @author Abhijit.Daund
 */
@Data
@Entity(name = "employee")
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "emp_id", updatable = false, nullable = false)
    private String empId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "work_phone")
    private String workPhone;

    @Column(name = "work_email")
    private String workEmail;

    @Column(name = "skype_id")
    private String skypeId;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "creator_user_id")
    private String creatorUserId;

    @Column(name = "create_ts")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTS;

    @Column(name = "last_modifier_user_id")
    private String lastModifierUserId;

    @Column(name = "last_mod_ts")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModTS;

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
        if (!(obj instanceof Employee))
            return false;
        final Employee other = (Employee) obj;
        if (empId == null) {
            if (other.empId != null)
                return false;
        } else if (!empId.equals(other.empId))
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
        return result;
    }
}
