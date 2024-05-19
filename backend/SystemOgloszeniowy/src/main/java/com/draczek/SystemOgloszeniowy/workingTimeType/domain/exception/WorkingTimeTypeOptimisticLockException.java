package com.draczek.SystemOgloszeniowy.workingTimeType.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.OptimisticLockException;

/**
 * Implementation of WorkingTimeType's invalid version exception.
 */
public class WorkingTimeTypeOptimisticLockException extends OptimisticLockException {
  private static final String DEFAULT_CODE = "working_time_type_optimistic_lock";

  public WorkingTimeTypeOptimisticLockException() {
    super("Version of WorkingTimeType is invalid", DEFAULT_CODE);
  }
}
