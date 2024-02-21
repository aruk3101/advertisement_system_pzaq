package com.draczek.SystemOgloszeniowy.educationLevel.domain.dto;

import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * UpdateEducationLevelDto dto.
 */
@Value
public class UpdateEducationLevelDto {

  String name;

  @NotNull
  Integer version;
}
