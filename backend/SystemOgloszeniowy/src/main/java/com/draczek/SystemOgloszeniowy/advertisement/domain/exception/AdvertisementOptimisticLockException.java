package com.draczek.SystemOgloszeniowy.advertisement.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.OptimisticLockException;

/**
 * Implementation of Advertisement's invalid version exception.
 */
public class AdvertisementOptimisticLockException extends OptimisticLockException {
  private static final String DEFAULT_CODE = "company_optimistic_lock";

  public AdvertisementOptimisticLockException() {
    super("Version of Advertisement is invalid", DEFAULT_CODE);
  }
}