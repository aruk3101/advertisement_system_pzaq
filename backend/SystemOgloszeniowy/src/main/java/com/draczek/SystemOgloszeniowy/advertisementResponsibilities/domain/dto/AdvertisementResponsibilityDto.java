package com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.dto;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * AdvertisementResponsibilityDto dto.
 */
@Value
public class AdvertisementResponsibilityDto {
  UUID uuid;

  String name;

  @NotNull
  Integer version;
}

