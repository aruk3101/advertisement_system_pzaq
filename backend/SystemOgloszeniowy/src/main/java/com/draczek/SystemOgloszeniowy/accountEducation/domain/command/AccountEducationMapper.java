package com.draczek.SystemOgloszeniowy.accountEducation.domain.command;

import com.draczek.SystemOgloszeniowy.accountEducation.domain.dto.AccountEducationDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

/**
 * Mapper AccountEducation.
 */
@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountEducationMapper {
  @Mappings({
  })
  AccountEducationDto toDto(AccountEducation accountEducation);
}
