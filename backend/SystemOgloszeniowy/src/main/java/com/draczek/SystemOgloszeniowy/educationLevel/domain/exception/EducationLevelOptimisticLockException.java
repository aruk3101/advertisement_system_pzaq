package com.draczek.SystemOgloszeniowy.educationLevel.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.OptimisticLockException;

/**
 * Implementation of EducationLevel's invalid version exception.
 */
public class EducationLevelOptimisticLockException extends OptimisticLockException {
  private static final String DEFAULT_CODE = "education_level_optimistic_lock";

  public EducationLevelOptimisticLockException() {
    super("Version of EducationLevel is invalid", DEFAULT_CODE);
  }
}
