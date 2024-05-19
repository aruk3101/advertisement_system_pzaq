package com.draczek.SystemOgloszeniowy.jobType.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.OptimisticLockException;

/**
 * Implementation of JobType's invalid version exception.
 */
public class JobTypeOptimisticLockException extends OptimisticLockException {
  private static final String DEFAULT_CODE = "job_type_optimistic_lock";

  public JobTypeOptimisticLockException() {
    super("Version of JobType is invalid", DEFAULT_CODE);
  }
}
