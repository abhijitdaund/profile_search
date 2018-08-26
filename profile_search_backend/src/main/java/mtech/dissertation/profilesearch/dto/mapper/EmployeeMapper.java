package mtech.dissertation.profilesearch.dto.mapper;

import java.util.Date;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import mtech.dissertation.profilesearch.dto.EmployeeDTO;
import mtech.dissertation.profilesearch.entity.Employee;

/**
 * Employee Mapper class.
 * 
 * @author Abhijit.Daund
 */
@Mapper(componentModel = "spring")
@Component
public abstract class EmployeeMapper {

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

    /**
     * Maps given Employee to EmployeeDTO.
     * 
     * @param employee
     *            an employee
     * @return an employeeDTO
     * @throws Exception
     */
    @Mappings({ @Mapping(source = "empId", target = "empId"), @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "middleName", target = "middleName"), @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "gender", target = "gender"), @Mapping(source = "mobile", target = "mobile"),
            @Mapping(source = "workPhone", target = "workPhone"), @Mapping(source = "workEmail", target = "workEmail"),
            @Mapping(source = "skypeId", target = "skypeId"), @Mapping(source = "active", target = "active"),
            @Mapping(source = "creatorUserId", target = "creatorUserId"),
            @Mapping(source = "createdTS", target = "createdTS"),
            @Mapping(source = "lastModifierUserId", target = "lastModifierUserId"),
            @Mapping(source = "lastModTS", target = "lastModTS") })
    @Named("toEmployeeDTO")
    public abstract EmployeeDTO toEmployeeDTO(Employee employee) throws Exception;

    /**
     * Maps give Employee list to EmployeeDTO list.
     * 
     * @param employeeList
     *            a list of employees
     * @return a list of employeeDTO
     * @throws Exception
     */
    @IterableMapping(qualifiedByName = "toEmployeeDTO")
    public abstract List<EmployeeDTO> toEmployeeDTOList(Iterable<Employee> employeeList) throws Exception;
}
