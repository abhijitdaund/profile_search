package mtech.dissertation.profilesearch.dto.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import mtech.dissertation.profilesearch.dto.SkillDTO;
import mtech.dissertation.profilesearch.entity.Skill;
import mtech.dissertation.profilesearch.exception.UnexpectedException;

/**
 * Skill Mapper class.
 * 
 * @author Abhijit.Daund
 */
@Mapper(componentModel = "spring")
@Component
public abstract class SkillMapper {

    /**
     * Maps given Skill to SkillDTO.
     * 
     * @param skill
     *            a skill
     * @return a skillDTO
     * @throws Exception
     */
    @Mappings({ // @Mapping(source = "id", target = "id"),
            @Mapping(source = "skillName", target = "skillName"), })
    @Named("toSkillDTO")
    public abstract SkillDTO toSkillDTO(Skill skill) throws UnexpectedException;

    /**
     * Maps given Skill list to SkillDTO list.
     * 
     * @param skillList
     *            a list of kills
     * @return a list of skillDTO
     * @throws Exception
     */
    @IterableMapping(qualifiedByName = "toSkillDTO")
    public abstract List<SkillDTO> toSkillDTOList(Iterable<Skill> skillList) throws UnexpectedException;

    /**
     * Maps given SkillDTO to Skill entity.
     * 
     * @param skillDTO
     *            a skill DTO
     * @return a skill entity
     * @throws Exception
     */
    @Mappings({ // @Mapping(source = "id", target = "id"),
            @Mapping(source = "skillName", target = "skillName"), })
    @Named("toSkillEntity")
    public abstract Skill toSkillEntity(SkillDTO skillDTO) throws UnexpectedException;
}
