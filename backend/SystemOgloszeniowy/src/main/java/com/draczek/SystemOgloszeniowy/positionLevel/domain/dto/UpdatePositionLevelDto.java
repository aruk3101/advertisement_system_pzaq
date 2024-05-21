package com.draczek.SystemOgloszeniowy.positionLevel.domain.dto;

import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * UpdatePositionLevelDto dto.
 */
@Value
public class UpdatePositionLevelDto {
  String name;

  @NotNull
  Integer version;
}
