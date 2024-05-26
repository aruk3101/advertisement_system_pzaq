package com.draczek.SystemOgloszeniowy.advertisement.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.EntityNotFoundException;
import java.util.UUID;

/**
 * AdvertisementNotFoundException entity not found exception.
 */
public final class AdvertisementNotFoundException extends EntityNotFoundException {

  private static final String DEFAULT_CODE = "advertisement_not_found";

  public AdvertisementNotFoundException(UUID uuid) {
    super(String.format("Could not find Advertisement with UUID: %s", uuid), DEFAULT_CODE);
  }
}
