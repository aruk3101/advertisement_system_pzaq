package com.draczek.SystemOgloszeniowy.languageLevel.domain.command;

import com.draczek.SystemOgloszeniowy.languageLevel.domain.dto.LanguageLevelDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

/**
 * Mapper LanguageLevel.
 */
@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface LanguageLevelMapper {
  @Mappings({
  })
  LanguageLevelDto toDto(LanguageLevel languageLevel);
}
