package com.draczek.SystemOgloszeniowy.languageLevel.domain.dto;

import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * UpdateLanguageLevelDto dto.
 */
@Value
public class UpdateLanguageLevelDto {
  String name;

  @NotNull
  Integer version;
}

