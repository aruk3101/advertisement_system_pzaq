package com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.dto;

import java.util.UUID;
import lombok.Value;

/**
 * CreateAdvertisementResponsibilityDto dto.
 */
@Value
public class CreateAdvertisementResponsibilityDto {
  String name;

  UUID advertisementUuid;
}
