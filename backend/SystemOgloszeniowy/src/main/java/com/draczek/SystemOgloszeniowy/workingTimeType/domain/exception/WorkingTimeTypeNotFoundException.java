package com.draczek.SystemOgloszeniowy.workingTimeType.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.EntityNotFoundException;

import java.util.UUID;

/**
 * WorkingTimeTypeNotFoundException entity not found exception.
 */
public final class WorkingTimeTypeNotFoundException extends EntityNotFoundException {

  private static final String DEFAULT_CODE = "working_time_type_not_found";

  public WorkingTimeTypeNotFoundException(UUID uuid) {
    super(String.format("Could not find Working time type with UUID: %s", uuid), DEFAULT_CODE);
  }
}
