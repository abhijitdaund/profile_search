package mtech.dissertation.profilesearch.dto.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import mtech.dissertation.profilesearch.dto.LevelDTO;
import mtech.dissertation.profilesearch.entity.Level;
import mtech.dissertation.profilesearch.exception.UnexpectedException;

/**
 * Level Mapper class.
 * 
 * @author Abhijit.Daund
 */
@Mapper(componentModel = "spring")
@Component
public abstract class LevelMapper {

    /**
     * Maps given Level to LevelDTO.
     * 
     * @param level
     *            a level
     * @return an levelDTO
     * @throws UnexpectedException
     */
    @Mappings({ @Mapping(source = "levelName", target = "levelName") })
    @Named("toLevelDTO")
    public abstract LevelDTO toLevelDTO(final Level level) throws UnexpectedException;

    /**
     * Maps given Level list to LevelDTO list.
     * 
     * @param levelList
     *            a list of levels
     * @return a list of levelDTO
     * @throws UnexpectedException
     */
    @IterableMapping(qualifiedByName = "toLevelDTO")
    public abstract List<LevelDTO> toLevelDTOList(final Iterable<Level> levelList) throws UnexpectedException;
}
