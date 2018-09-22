package mtech.dissertation.profilesearch.dto.mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import mtech.dissertation.profilesearch.dto.EmployeeSkillDetailDTO;
import mtech.dissertation.profilesearch.dto.EmployeeSkillDetailsDTO;
import mtech.dissertation.profilesearch.dto.SkillDetailDTO;
import mtech.dissertation.profilesearch.entity.EmployeeSkillDetails;
import mtech.dissertation.profilesearch.exception.UnexpectedException;
import mtech.dissertation.profilesearch.util.CollectionUtil;

/**
 * Employee Skill Detail Mapper class.
 * 
 * @author Abhijit.Daund
 */
@Mapper(componentModel = "spring", uses = { EmployeeMapper.class, SkillMapper.class, LevelMapper.class })
@Component
public abstract class EmployeeSkillDetailMapper {

    /**
     * Maps given EmployeeSkillDetail to EmployeeSkillDetailDTO
     * 
     * @param employeeSkillDetail
     *            an EmployeeSkillDetail
     * @return an EmployeeSkillDetailDTO
     * @throws UnexpectedException
     */
    @Mappings({
            @Mapping(source = "employee", target = "employeeDTO", qualifiedByName = { "EmployeeMapper",
                    "toEmployeeDTO" }),
            @Mapping(source = "skill", target = "skillDTO", qualifiedByName = { "SkillMapper", "toSkillDTO" }),
            @Mapping(source = "level", target = "levelDTO", qualifiedByName = { "LevelMapper", "toLevelDTO" }) })
    @Named("toEmployeeSkillDetailDTO")
    public abstract EmployeeSkillDetailDTO toEmployeeSkillDetailDTO(final EmployeeSkillDetails employeeSkillDetail)
            throws UnexpectedException;

    /**
     * Maps given EmployeeSkillDetail list to EmployeeSkillDetailDTO list.
     * 
     * @param empSkillDetailList
     *            a list of EmployeeSkillDetail
     * @return a list of EmployeeSkillDetailDTO
     * @throws UnexpectedException
     */
    @IterableMapping(qualifiedByName = "toEmployeeSkillDetailDTO")
    public abstract List<EmployeeSkillDetailDTO> toEmployeeSkillDetailDTOList(
            final List<EmployeeSkillDetails> empSkillDetailList) throws UnexpectedException;

    /**
     * Maps given EmployeeSkillDetail to EmployeeSkillDetailsDTO
     * 
     * @param employeeSkillDetail
     *            an EmployeeSkillDetail
     * @return a list of EmployeeSkillDetailsDTO
     * @throws UnexpectedException
     */
    public List<EmployeeSkillDetailsDTO> toEmployeeSkillDetailsDTOList(final EmployeeSkillDetails employeeSkillDetail)
            throws UnexpectedException {
        return toEmployeeSkillDetailsDTOListHelper(Arrays.asList(toEmployeeSkillDetailDTO(employeeSkillDetail)));
    }

    /**
     * Maps given EmployeeSkillDetail list to EmployeeSkillDetailsDTO list.
     * 
     * @param empSkillDetailList
     *            a list of EmployeeSkillDetail
     * @return a list of EmployeeSkillDetailsDTO
     * @throws UnexpectedException
     */
    public List<EmployeeSkillDetailsDTO> toEmployeeSkillDetailsDTOList(
            final List<EmployeeSkillDetails> empSkillDetailList) throws UnexpectedException {
        return toEmployeeSkillDetailsDTOListHelper(toEmployeeSkillDetailDTOList(empSkillDetailList));
    }

    /**
     * Maps given empSkillDetail list to an EmployeeSkillDetailsDTO.
     * 
     * @param empId
     *            the employee id
     * @param empSkillDetailsList
     *            a list of empSkillDetails
     * @return an EmployeeSkillDetailsDTO
     * @throws UnexpectedException
     */
    public EmployeeSkillDetailsDTO toEmployeeSkillDetailsDTO(final String empId,
            final List<EmployeeSkillDetails> empSkillDetailsList) throws UnexpectedException {
        final Map<String, EmployeeSkillDetailsDTO> esdDTOMap = new LinkedHashMap<String, EmployeeSkillDetailsDTO>();

        for (final EmployeeSkillDetailDTO dto : toEmployeeSkillDetailDTOList(empSkillDetailsList)) {
            if (null == esdDTOMap.get(dto.getEmployeeDTO().getEmpId())) {
                final EmployeeSkillDetailsDTO esDetailsDTO = new EmployeeSkillDetailsDTO();
                esDetailsDTO.setEmployeeDTO(dto.getEmployeeDTO());
                esDetailsDTO.setSkillDetailDTO(new ArrayList<SkillDetailDTO>());
                esdDTOMap.put(dto.getEmployeeDTO().getEmpId(), esDetailsDTO);
            }

            final SkillDetailDTO sdDTO = new SkillDetailDTO();
            sdDTO.setLevelName(dto.getLevelDTO().getLevelName());
            sdDTO.setSkillName(dto.getSkillDTO().getSkillName());
            esdDTOMap.get(dto.getEmployeeDTO().getEmpId()).getSkillDetailDTO().add(sdDTO);
        }

        return esdDTOMap.get(empId);
    }

    /**
     * Maps given EmployeeSkillDetailDTO list to EmployeeSkillDetailsDTO list.
     * 
     * @param empSkillDetailDTOList
     *            a list of EmployeeSkillDetailDTO
     * @return a list of EmployeeSkillDetailsDTO
     * @throws UnexpectedException
     */
    private static List<EmployeeSkillDetailsDTO> toEmployeeSkillDetailsDTOListHelper(
            final List<EmployeeSkillDetailDTO> empSkillDetailDTOList) throws UnexpectedException {
        final Map<String, EmployeeSkillDetailsDTO> esdDTOMap = new LinkedHashMap<String, EmployeeSkillDetailsDTO>();

        for (final EmployeeSkillDetailDTO dto : empSkillDetailDTOList) {
            if (null == esdDTOMap.get(dto.getEmployeeDTO().getEmpId())) {
                final EmployeeSkillDetailsDTO esDetailsDTO = new EmployeeSkillDetailsDTO();
                esDetailsDTO.setEmployeeDTO(dto.getEmployeeDTO());
                esDetailsDTO.setSkillDetailDTO(new ArrayList<SkillDetailDTO>());
                esdDTOMap.put(dto.getEmployeeDTO().getEmpId(), esDetailsDTO);
            }

            final SkillDetailDTO sdDTO = new SkillDetailDTO();
            sdDTO.setLevelName(dto.getLevelDTO().getLevelName());
            sdDTO.setSkillName(dto.getSkillDTO().getSkillName());
            esdDTOMap.get(dto.getEmployeeDTO().getEmpId()).getSkillDetailDTO().add(sdDTO);
        }

        return CollectionUtil.toList(esdDTOMap.values());
    }
}
