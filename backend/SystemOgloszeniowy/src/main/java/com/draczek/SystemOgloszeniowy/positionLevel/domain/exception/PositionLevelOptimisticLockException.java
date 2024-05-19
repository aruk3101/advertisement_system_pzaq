package com.draczek.SystemOgloszeniowy.positionLevel.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.OptimisticLockException;

/**
 * Implementation of PositionLevel's invalid version exception.
 */
public class PositionLevelOptimisticLockException extends OptimisticLockException {
  private static final String DEFAULT_CODE = "position_level_optimistic_lock";

  public PositionLevelOptimisticLockException() {
    super("Version of PositionLevel is invalid", DEFAULT_CODE);
  }
}
