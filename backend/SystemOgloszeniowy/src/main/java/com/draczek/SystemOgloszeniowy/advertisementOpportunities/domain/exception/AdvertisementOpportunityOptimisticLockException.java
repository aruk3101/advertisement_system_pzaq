package com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.OptimisticLockException;

/**
 * Implementation of AdvertisementOpportunityOptimisticLockException's invalid version exception.
 */
public class AdvertisementOpportunityOptimisticLockException extends OptimisticLockException {
  private static final String DEFAULT_CODE = "advertisement_opportunity_optimistic_lock";

  public AdvertisementOpportunityOptimisticLockException() {
    super("Version of AdvertisementOpportunity is invalid", DEFAULT_CODE);
  }
}
