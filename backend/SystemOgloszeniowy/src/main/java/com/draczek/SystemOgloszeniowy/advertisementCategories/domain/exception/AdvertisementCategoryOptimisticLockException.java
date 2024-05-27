package com.draczek.SystemOgloszeniowy.advertisementCategories.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.OptimisticLockException;

/**
 * Implementation of AdvertisementCategory's invalid version exception.
 */
public class AdvertisementCategoryOptimisticLockException extends OptimisticLockException {
  private static final String DEFAULT_CODE = "advertisement_categor_optimistic_lock";

  public AdvertisementCategoryOptimisticLockException() {
    super("Version of AdvertisementCategory is invalid", DEFAULT_CODE);
  }
}
