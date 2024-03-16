package com.draczek.SystemOgloszeniowy.accountLanguage.domain.command;

import com.draczek.SystemOgloszeniowy.accountLanguage.domain.dto.AccountLanguageDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

/**
 * Mapper AccountLanguage.
 */
@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountLanguageMapper {
  @Mappings({
  })
  AccountLanguageDto toDto(AccountLanguage accountLanguages);
}
