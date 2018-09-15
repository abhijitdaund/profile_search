package mtech.dissertation.profilesearch.dto.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import mtech.dissertation.profilesearch.dto.EmployeeDTO;
import mtech.dissertation.profilesearch.entity.Employee;
import mtech.dissertation.profilesearch.exception.UnexpectedException;

/**
 * Employee Mapper class.
 * 
 * @author Abhijit.Daund
 */
@Mapper(componentModel = "spring")
@Component
public abstract class EmployeeMapper {

    /**
     * Maps given Employee to EmployeeDTO.
     * 
     * @param employee
     *            an employee
     * @return an employeeDTO
     * @throws UnexpectedException
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
    public abstract EmployeeDTO toEmployeeDTO(Employee employee) throws UnexpectedException;

    /**
     * Maps given Employee list to EmployeeDTO list.
     * 
     * @param employeeList
     *            a list of employees
     * @return a list of employeeDTO
     * @throws UnexpectedException
     */
    @IterableMapping(qualifiedByName = "toEmployeeDTO")
    public abstract List<EmployeeDTO> toEmployeeDTOList(Iterable<Employee> employeeList) throws UnexpectedException;

    /**
     * Maps given EmployeeDTO to Employee entity.
     * 
     * @param employeeDTO
     *            an employee DTO
     * @return an employee entity
     * @throws UnexpectedException
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
    @Named("toEmployeeEntity")
    public abstract Employee toEmployeeEntity(EmployeeDTO employeeDTO) throws UnexpectedException;
}
