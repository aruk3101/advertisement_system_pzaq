package com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.OptimisticLockException;

/**
 * Implementation of AdvertisementResponsibility's invalid version exception.
 */
public class AdvertisementResponsibilityOptimisticLockException extends OptimisticLockException {
  private static final String DEFAULT_CODE = "advertisement_responsibility_optimistic_lock";

  public AdvertisementResponsibilityOptimisticLockException() {
    super("Version of AdvertisementsResponsibility is invalid", DEFAULT_CODE);
  }
}
