package com.draczek.SystemOgloszeniowy.accountLanguage.domain.dto;

import java.util.UUID;
import lombok.Value;

/**
 * CreateAccountLanguageDto dto.
 */
@Value
public class CreateAccountLanguageDto {
  String language;

  UUID languageLevelUuid;
}

