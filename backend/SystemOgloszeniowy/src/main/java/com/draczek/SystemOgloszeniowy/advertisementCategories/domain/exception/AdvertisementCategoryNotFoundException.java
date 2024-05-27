package com.draczek.SystemOgloszeniowy.advertisementCategories.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.EntityNotFoundException;
import java.util.UUID;

/**
 * AdvertisementCategoryNotFoundException entity not found exception.
 */
public final class AdvertisementCategoryNotFoundException extends EntityNotFoundException {

  private static final String DEFAULT_CODE = "advertisement_category_not_found";

  public AdvertisementCategoryNotFoundException(UUID uuid) {
    super(String.format("Could not find Advertisement category with UUID: %s", uuid), DEFAULT_CODE);
  }
}