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
    @Column(name = "emp_code", updatable = false, nullable = false)
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
}
