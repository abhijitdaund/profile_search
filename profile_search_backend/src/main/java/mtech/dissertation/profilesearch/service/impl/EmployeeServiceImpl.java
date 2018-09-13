package mtech.dissertation.profilesearch.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mtech.dissertation.profilesearch.dto.EmployeeDTO;
import mtech.dissertation.profilesearch.dto.mapper.EmployeeMapper;
import mtech.dissertation.profilesearch.entity.Employee;
import mtech.dissertation.profilesearch.exception.EntityNotFoundException;
import mtech.dissertation.profilesearch.exception.UnexpectedException;
import mtech.dissertation.profilesearch.repository.EmployeeRepository;
import mtech.dissertation.profilesearch.service.api.EmployeeService;

/**
 * Employee Service Implementation.
 * 
 * @author Abhijit.Daund
 */
@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee, EmployeeRepository, String>
        implements
        EmployeeService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeMapper employeeMapper;

    /*
     * (non-Javadoc)
     * @see
     * mtech.dissertation.profilesearch.service.api.EmployeeService#findEmployeeById
     * (java.lang.String)
     */
    @Override
    public EmployeeDTO findEmployeeById(final String id) throws EntityNotFoundException, UnexpectedException {
        LOG.info("findEmployeeById(): id: " + id);
        Employee employee;
        try {
            employee = super.findOne(id);
        } catch (final javax.persistence.EntityNotFoundException e) {
            LOG.error("findEmployeeById(): ", e);
            throw new EntityNotFoundException(Employee.class.getSimpleName(), id);
        } catch (final IOException e) {
            LOG.error("findEmployeeById(): ", e);
            throw new UnexpectedException(e.getStackTrace());
        } catch (final Exception e) {
            LOG.error("findEmployeeById(): ", e);
            throw new UnexpectedException(e.getStackTrace());
        }

        if (null == employee) {
            throw new EntityNotFoundException(Employee.class.getSimpleName(), id);
        }
        return employeeMapper.toEmployeeDTO(employee);
    }

    /*
     * (non-Javadoc)
     * @see
     * mtech.dissertation.profilesearch.service.api.EmployeeService#findAllEmployees
     * ()
     */
    @Override
    public List<EmployeeDTO> findAllEmployees() throws UnexpectedException {
        LOG.info("findAllEmployees(): ");
        return employeeMapper.toEmployeeDTOList(super.findAll());
    }

    /*
     * (non-Javadoc)
     * @see
     * mtech.dissertation.profilesearch.service.api.EmployeeService#addEmployee(
     * mtech.dissertation.profilesearch.dto.EmployeeDTO)
     */
    @Override
    public EmployeeDTO addEmployee(final EmployeeDTO employeeDTO) throws UnexpectedException {
        LOG.info("addEmployee(): empId: " + employeeDTO.getEmpId());

        try {
            final EmployeeDTO existingEmpDTO = findEmployeeById(employeeDTO.getEmpId());
            final Date date = new Date();
            employeeDTO.setCreatedTS(existingEmpDTO.getCreatedTS());
            employeeDTO.setLastModTS(date);
        } catch (final EntityNotFoundException e) {
            final Date date = new Date();
            employeeDTO.setCreatedTS(date);
            employeeDTO.setLastModTS(date);
        }

        return employeeMapper.toEmployeeDTO(repository.save(employeeMapper.toEmployeeEntity(employeeDTO)));
    }
}
