package com.draczek.SystemOgloszeniowy.accountLanguage.domain.dto;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * UpdateAccountLanguageDto dto.
 */
@Value
public class UpdateAccountLanguageDto {
  String language;

  UUID languageLevelUuid;

  @NotNull
  Integer version;
}