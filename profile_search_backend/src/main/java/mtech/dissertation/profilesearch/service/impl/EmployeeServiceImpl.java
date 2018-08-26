package mtech.dissertation.profilesearch.service.impl;

import org.springframework.stereotype.Service;

import mtech.dissertation.profilesearch.entity.Employee;
import mtech.dissertation.profilesearch.repository.EmployeeRepository;
import mtech.dissertation.profilesearch.service.api.EmployeeService;

/**
 * @author Abhijit.Daund
 */
@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee, EmployeeRepository, String>
        implements
        EmployeeService {

}
