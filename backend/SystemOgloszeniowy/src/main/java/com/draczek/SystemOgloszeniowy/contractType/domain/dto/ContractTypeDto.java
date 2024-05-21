package com.draczek.SystemOgloszeniowy.contractType.domain.dto;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * ContractTypeDto dto.
 */
@Value
public class ContractTypeDto {
  UUID uuid;

  String name;

  @NotNull
  Integer version;
}
