package com.draczek.SystemOgloszeniowy.accountSkill.domain.command;

import com.draczek.SystemOgloszeniowy.accountSkill.domain.dto.AccountSkillDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

/**
 * Mapper AccountSkill.
 */
@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountSkillMapper {
  @Mappings({
  })
  AccountSkillDto toDto(AccountSkill accountSkill);
}
