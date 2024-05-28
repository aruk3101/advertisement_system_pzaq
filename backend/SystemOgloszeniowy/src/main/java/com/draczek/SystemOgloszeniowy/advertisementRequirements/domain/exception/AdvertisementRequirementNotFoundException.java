package com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.EntityNotFoundException;
import java.util.UUID;

/**
 * AdvertisementRequirementNotFoundException entity not found exception.
 */
public final class AdvertisementRequirementNotFoundException extends EntityNotFoundException {

  private static final String DEFAULT_CODE = "advertisement_requirement_not_found";

  public AdvertisementRequirementNotFoundException(UUID uuid) {
    super(String.format("Could not find Advertisement requirement with UUID: %s", uuid), DEFAULT_CODE);
  }
}