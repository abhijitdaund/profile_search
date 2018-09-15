package mtech.dissertation.profilesearch.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mtech.dissertation.profilesearch.dto.EmployeeSkillDetailsDTO;
import mtech.dissertation.profilesearch.dto.mapper.EmployeeSkillDetailMapper;
import mtech.dissertation.profilesearch.entity.EmployeeSkillDetail;
import mtech.dissertation.profilesearch.exception.EntityNotFoundException;
import mtech.dissertation.profilesearch.exception.UnexpectedException;
import mtech.dissertation.profilesearch.repository.EmployeeSkillDetailsRepository;
import mtech.dissertation.profilesearch.service.api.EmployeeSkillDetailsService;

/**
 * Employee Service Implementation.
 * 
 * @author Abhijit.Daund
 */
@Service
public class EmployeeSkillDetailServiceImpl
        extends BaseServiceImpl<EmployeeSkillDetail, EmployeeSkillDetailsRepository, String>
        implements
        EmployeeSkillDetailsService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeSkillDetailServiceImpl.class);

    @Autowired
    private EmployeeSkillDetailMapper empSkillDetailsMapper;

    /*
     * (non-Javadoc)
     * @see
     * mtech.dissertation.profilesearch.service.api.EmployeeSkillDetailsService#
     * findEmployeeSkillDetails(java.lang.String)
     */
    @Override
    public List<EmployeeSkillDetailsDTO> findEmployeeSkillDetails(final String empId)
            throws EntityNotFoundException, UnexpectedException {
        LOG.info("findEmployeeSkillDetails(): empId: " + empId);
        final List<EmployeeSkillDetail> employeeSkillDetails = repository.findEmployeeSkillDetails(empId);
        return empSkillDetailsMapper.toEmployeeSkillDetailsDTOList(employeeSkillDetails);
    }

    /*
     * (non-Javadoc)
     * @see
     * mtech.dissertation.profilesearch.service.api.EmployeeSkillDetailsService#
     * findAllEmpSkillDetails()
     */
    @Override
    public List<EmployeeSkillDetailsDTO> findAllEmpSkillDetails() throws UnexpectedException {
        LOG.info("findAllEmpSkillDetails(): ");
        return empSkillDetailsMapper.toEmployeeSkillDetailsDTOList(findAll());
    }
}
