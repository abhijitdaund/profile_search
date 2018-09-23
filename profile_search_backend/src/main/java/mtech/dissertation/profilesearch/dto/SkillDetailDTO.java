package mtech.dissertation.profilesearch.dto;

import lombok.Data;

/**
 * Skill Detail DTO class.
 * 
 * @author Abhijit.Daund
 */
@Data
public class SkillDetailDTO {

    private String skillName;
    private String levelName;
    private boolean isDeleted;
}
