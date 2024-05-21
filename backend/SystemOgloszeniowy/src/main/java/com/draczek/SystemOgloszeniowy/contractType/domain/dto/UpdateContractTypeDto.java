package com.draczek.SystemOgloszeniowy.contractType.domain.dto;

import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * UpdateContractTypeDto dto.
 */
@Value
public class UpdateContractTypeDto {
  String name;

  @NotNull
  Integer version;
}
