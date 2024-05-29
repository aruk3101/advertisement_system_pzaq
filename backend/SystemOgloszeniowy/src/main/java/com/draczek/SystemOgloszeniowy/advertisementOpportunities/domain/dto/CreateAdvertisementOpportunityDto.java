package com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.dto;

import java.util.UUID;
import lombok.Value;

/**
 * CreateAdvertisementOpportunityDto dto.
 */
@Value
public class CreateAdvertisementOpportunityDto {
  String name;

  UUID advertisementUuid;
}