package com.draczek.SystemOgloszeniowy.workingTimeType.domain.dto;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * WorkingTimeTypeDto dto.
 */
@Value
public class WorkingTimeTypeDto {
  UUID uuid;

  String name;

  @NotNull
  Integer version;
}
