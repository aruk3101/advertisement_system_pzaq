package com.draczek.SystemOgloszeniowy.accountLanguage.domain.dto;

import com.draczek.SystemOgloszeniowy.languageLevel.domain.dto.LanguageLevelDto;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * AccountLanguageDto dto.
 */
@Value
public class AccountLanguageDto {
  UUID uuid;

  String language;

  LanguageLevelDto languageLevel;

  @NotNull
  Integer version;
}
