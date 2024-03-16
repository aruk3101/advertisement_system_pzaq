package com.draczek.SystemOgloszeniowy.languageLevel.domain.dto;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * LanguageLevelDto dto.
 */
@Value
public class LanguageLevelDto {
  UUID uuid;

  String name;

  @NotNull
  Integer version;
}
