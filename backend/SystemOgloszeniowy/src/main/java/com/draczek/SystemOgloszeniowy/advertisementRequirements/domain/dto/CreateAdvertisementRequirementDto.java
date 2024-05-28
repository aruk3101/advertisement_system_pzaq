package com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.dto;

import java.util.UUID;
import lombok.Value;

/**
 * CreateAdvertisementRequirementDto dto.
 */
@Value
public class CreateAdvertisementRequirementDto {
  String name;

  UUID advertisementUuid;
}

