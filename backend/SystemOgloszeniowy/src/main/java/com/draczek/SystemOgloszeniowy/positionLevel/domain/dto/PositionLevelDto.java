package com.draczek.SystemOgloszeniowy.positionLevel.domain.dto;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * PositionLevelDto dto.
 */
@Value
public class PositionLevelDto {
  UUID uuid;

  String name;

  @NotNull
  Integer version;
}

