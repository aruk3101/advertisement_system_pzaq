package com.draczek.SystemOgloszeniowy.jobType.domain.dto;

import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * UpdateJobTypeDto dto.
 */
@Value
public class UpdateJobTypeDto {
  String name;

  @NotNull
  Integer version;
}
