package com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.dto;

import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * UpdateAdvertisementResponsibilityDto dto.
 */
@Value
public class UpdateAdvertisementResponsibilityDto {
  String name;

  @NotNull
  Integer version;
}
