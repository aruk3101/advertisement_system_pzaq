package com.draczek.SystemOgloszeniowy.workingTimeType.domain.dto;

import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * UpdateWorkingTimeTypeDto dto.
 */
@Value
public class UpdateWorkingTimeTypeDto {
  String name;

  @NotNull
  Integer version;
}

