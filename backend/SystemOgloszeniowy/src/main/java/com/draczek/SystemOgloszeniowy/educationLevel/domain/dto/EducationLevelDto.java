package com.draczek.SystemOgloszeniowy.educationLevel.domain.dto;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * EducationLevelDto dto.
 */
@Value
public class EducationLevelDto {
  UUID uuid;

  String name;

  @NotNull
  Integer version;
}

