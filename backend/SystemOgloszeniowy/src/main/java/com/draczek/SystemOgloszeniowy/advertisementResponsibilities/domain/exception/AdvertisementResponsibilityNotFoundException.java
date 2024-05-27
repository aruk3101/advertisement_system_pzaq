package com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.EntityNotFoundException;
import java.util.UUID;

/**
 * AdvertisementResponsibilityNotFoundException entity not found exception.
 */
public final class AdvertisementResponsibilityNotFoundException extends EntityNotFoundException {

  private static final String DEFAULT_CODE = "advertisement_responsibility_not_found";

  public AdvertisementResponsibilityNotFoundException(UUID uuid) {
    super(String.format("Could not find Advertisement responsibility with UUID: %s", uuid), DEFAULT_CODE);
  }
}