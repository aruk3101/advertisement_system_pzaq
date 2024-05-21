package com.draczek.SystemOgloszeniowy.positionLevel.domain.command;

import com.draczek.SystemOgloszeniowy.positionLevel.domain.dto.PositionLevelDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

/**
 * Mapper PositionLevelMapper.
 */
@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PositionLevelMapper {
  @Mappings({
  })
  PositionLevelDto toDto(PositionLevel positionLevel);
}
