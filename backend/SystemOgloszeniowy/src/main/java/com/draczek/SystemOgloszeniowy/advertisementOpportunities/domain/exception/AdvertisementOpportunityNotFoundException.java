package com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.EntityNotFoundException;
import java.util.UUID;

/**
 * AdvertisementOpportunityNotFoundException entity not found exception.
 */
public final class AdvertisementOpportunityNotFoundException extends EntityNotFoundException {

  private static final String DEFAULT_CODE = "advertisement_opportunity_not_found";

  public AdvertisementOpportunityNotFoundException(UUID uuid) {
    super(String.format("Could not find Advertisement opportunity with UUID: %s", uuid), DEFAULT_CODE);
  }
}
