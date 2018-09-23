package mtech.dissertation.profilesearch.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mtech.dissertation.profilesearch.dto.EmployeeSkillDetailsDTO;
import mtech.dissertation.profilesearch.dto.SkillDetailDTO;
import mtech.dissertation.profilesearch.dto.mapper.EmployeeSkillDetailMapper;
import mtech.dissertation.profilesearch.entity.CompositeEmpSkillId;
import mtech.dissertation.profilesearch.entity.Employee;
import mtech.dissertation.profilesearch.entity.EmployeeSkillDetail;
import mtech.dissertation.profilesearch.entity.EmployeeSkillDetails;
import mtech.dissertation.profilesearch.entity.Level;
import mtech.dissertation.profilesearch.entity.Skill;
import mtech.dissertation.profilesearch.exception.EntityNotFoundException;
import mtech.dissertation.profilesearch.exception.UnexpectedException;
import mtech.dissertation.profilesearch.repository.EmployeeRepository;
import mtech.dissertation.profilesearch.repository.EmployeeSkillDetailRepository;
import mtech.dissertation.profilesearch.repository.LevelRepository;
import mtech.dissertation.profilesearch.repository.SkillRepository;
import mtech.dissertation.profilesearch.service.api.EmployeeSkillDetailService;
import mtech.dissertation.profilesearch.util.CollectionUtil;

/**
 * Employee Skill Detail Service Implementation.
 * 
 * @author Abhijit.Daund
 */
@Service
public class EmployeeSkillDetailServiceImpl
        extends BaseServiceImpl<EmployeeSkillDetail, EmployeeSkillDetailRepository, String>
        implements
        EmployeeSkillDetailService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeSkillDetailServiceImpl.class);

    @Autowired
    private EmployeeRepository empRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private LevelRepository levelRepository;

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
        final List<EmployeeSkillDetail> employeeSkillDetails = repository.findSkillDetailsByEmpId(empId);
        return empSkillDetailsMapper.toEmployeeSkillDetailsDTOList(toEmployeeSkillDetails(employeeSkillDetails));
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
        final List<EmployeeSkillDetails> employeeSkillDetailsList = toEmployeeSkillDetails(
                CollectionUtil.toList(findAll()));
        return empSkillDetailsMapper.toEmployeeSkillDetailsDTOList(employeeSkillDetailsList);
    }

    /*
     * (non-Javadoc)
     * @see mtech.dissertation.profilesearch.service.api.EmployeeSkillDetailService#
     * saveEmpSkillDetails(mtech.dissertation.profilesearch.dto.
     * EmployeeSkillDetailsDTO)
     */
    @Override
    public EmployeeSkillDetailsDTO saveEmpSkillDetails(final EmployeeSkillDetailsDTO esdDTO)
            throws EntityNotFoundException, UnexpectedException {
        LOG.info("saveEmpSkillDetails(): empId: " + esdDTO.getEmployeeDTO().getEmpId());

        for (final SkillDetailDTO skillDetailDTO : esdDTO.getSkillDetailDTO()) {
            final EmployeeSkillDetail empSkillDetail = new EmployeeSkillDetail();
            empSkillDetail.setCompositeEmpSkillId(new CompositeEmpSkillId());

            if (!empRepository.exists(esdDTO.getEmployeeDTO().getEmpId())) {
                LOG.error("saveEmpSkillDetails(): empId: " + esdDTO.getEmployeeDTO().getEmpId() + " not found");
                throw new EntityNotFoundException(Employee.class.getSimpleName(),
                        empSkillDetail.getCompositeEmpSkillId().getSkillId().toString());
            }

            empSkillDetail.getCompositeEmpSkillId().setEmpId(esdDTO.getEmployeeDTO().getEmpId());

            try {
                final int skillId = skillRepository.findSkillByName(skillDetailDTO.getSkillName()).getId();
                empSkillDetail.getCompositeEmpSkillId().setSkillId(skillId);
            } catch (final EntityNotFoundException e) {
                LOG.error("saveEmpSkillDetails(): ", e);
                throw new EntityNotFoundException(Skill.class.getSimpleName(),
                        empSkillDetail.getCompositeEmpSkillId().getSkillId().toString());
            }

            try {
                final int levelId = levelRepository.findLevelByName(skillDetailDTO.getLevelName()).getId();
                empSkillDetail.setLevelId(levelId);
            } catch (final EntityNotFoundException e) {
                LOG.error("saveEmpSkillDetails(): ", e);
                throw new EntityNotFoundException(Level.class.getSimpleName(), empSkillDetail.getLevelId().toString());
            }

            if (skillDetailDTO.isDeleted()) {
                delete(empSkillDetail);
                continue;
            }

            save(empSkillDetail);
        }

        final List<EmployeeSkillDetail> empSkillDetailList = repository
                .findSkillDetailsByEmpId(esdDTO.getEmployeeDTO().getEmpId());
        final List<EmployeeSkillDetails> employeeSkillDetailsList = toEmployeeSkillDetails(empSkillDetailList);
        return empSkillDetailsMapper.toEmployeeSkillDetailsDTO(esdDTO.getEmployeeDTO().getEmpId(),
                employeeSkillDetailsList);
    }

    private List<EmployeeSkillDetails> toEmployeeSkillDetails(final List<EmployeeSkillDetail> employeeSkillDetailList) {
        LOG.info("toEmployeeSkillDetails(): ");
        final List<EmployeeSkillDetails> empSkillDetailsList = new ArrayList<EmployeeSkillDetails>(
                employeeSkillDetailList.size());

        for (final EmployeeSkillDetail employeeSkillDetail : employeeSkillDetailList) {
            final EmployeeSkillDetails employeeSkillDetails = new EmployeeSkillDetails();
            final Employee employee = empRepository.findOne(employeeSkillDetail.getCompositeEmpSkillId().getEmpId());
            employeeSkillDetails.setEmployee(employee);

            final Skill skill = skillRepository.findOne(employeeSkillDetail.getCompositeEmpSkillId().getSkillId());
            employeeSkillDetails.setSkill(skill);

            final Level level = levelRepository.findOne(employeeSkillDetail.getLevelId());
            employeeSkillDetails.setLevel(level);

            empSkillDetailsList.add(employeeSkillDetails);
        }

        return empSkillDetailsList;
    }
}
