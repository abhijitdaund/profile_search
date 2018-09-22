package mtech.dissertation.profilesearch.dto;

import java.util.List;

import lombok.Data;

/**
 * Skill Details DTO class.
 * 
 * @author Abhijit.Daund
 */
@Data
public class SkillDetailsDTO {

    private String empId;
    private List<SkillDetailDTO> skillDetailDTOList;
}
