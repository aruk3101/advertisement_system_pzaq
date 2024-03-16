package com.draczek.SystemOgloszeniowy.accountExperience.domain.command;

import com.draczek.SystemOgloszeniowy.accountExperience.domain.dto.AccountExperienceDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

/**
 * Mapper AccountExperience.
 */
@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountExperienceMapper {
  @Mappings({
  })
  AccountExperienceDto toDto(AccountExperience accountExperience);
}
