package com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.OptimisticLockException;

/**
 * Implementation of AdvertisementRequirementOptimisticLockException's invalid version exception.
 */
public class AdvertisementRequirementOptimisticLockException extends OptimisticLockException {
  private static final String DEFAULT_CODE = "advertisement_requirement_optimistic_lock";

  public AdvertisementRequirementOptimisticLockException() {
    super("Version of AdvertisementRequirement is invalid", DEFAULT_CODE);
  }
}