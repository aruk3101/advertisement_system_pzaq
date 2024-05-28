package com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.dto;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * AdvertisementRequirementDto dto.
 */
@Value
public class AdvertisementRequirementDto {
  UUID uuid;

  String name;

  @NotNull
  Integer version;
}
