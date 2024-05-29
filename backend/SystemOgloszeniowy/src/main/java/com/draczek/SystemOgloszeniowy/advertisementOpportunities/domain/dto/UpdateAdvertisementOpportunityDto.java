package com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.dto;

import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * UpdateAdvertisementOpportunityDto.
 */
@Value
public class UpdateAdvertisementOpportunityDto {
  String name;

  @NotNull
  Integer version;
}

