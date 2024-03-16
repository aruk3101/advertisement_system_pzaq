package com.draczek.SystemOgloszeniowy.educationLevel.domain.command;

import com.draczek.SystemOgloszeniowy.educationLevel.domain.dto.EducationLevelDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

/**
 * Mapper EducationLevel.
 */
@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EducationLevelMapper {
  @Mappings({
  })
  EducationLevelDto toDto(EducationLevel educationLevel);
}
