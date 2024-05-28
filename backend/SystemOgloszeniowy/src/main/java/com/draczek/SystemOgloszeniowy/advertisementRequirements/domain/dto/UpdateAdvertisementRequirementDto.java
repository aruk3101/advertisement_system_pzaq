package com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.dto;

import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * UpdateAdvertisementRequirementDto.
 */
@Value
public class UpdateAdvertisementRequirementDto {
  String name;

  @NotNull
  Integer version;
}
