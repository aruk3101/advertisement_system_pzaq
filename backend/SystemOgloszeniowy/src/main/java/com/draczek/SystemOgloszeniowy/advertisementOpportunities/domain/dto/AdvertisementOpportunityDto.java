package com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.dto;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * AdvertisementOpportunityDto dto.
 */
@Value
public class AdvertisementOpportunityDto {
  UUID uuid;

  String name;

  @NotNull
  Integer version;
}
