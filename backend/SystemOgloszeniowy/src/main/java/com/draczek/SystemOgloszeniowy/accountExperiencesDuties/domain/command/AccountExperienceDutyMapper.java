package com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.command;

import com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.dto.AccountExperienceDutyDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

/**
 * Mapper AccountExperienceDuty.
 */
@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountExperienceDutyMapper {
  @Mappings({
  })
  AccountExperienceDutyDto toDto(AccountExperienceDuty accountExperienceDuty);
}

