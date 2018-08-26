package mtech.dissertation.profilesearch.dto;

import java.util.Date;

import lombok.Data;

/**
 * Employee DTO class.
 * 
 * @author Abhijit.Daund
 */
@Data
public class EmployeeDTO {

    private String empId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String mobile;
    private String workPhone;
    private String workEmail;
    private String skypeId;
    private boolean isActive;
    private String creatorUserId;
    private Date createdTS;
    private String lastModifierUserId;
    private Date lastModTS;
}
