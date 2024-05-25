package com.draczek.SystemOgloszeniowy.jobType.domain.dto;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * JobTypeDto dto.
 */
@Value
public class JobTypeDto {
  UUID uuid;

  String name;

  @NotNull
  Integer version;
}
