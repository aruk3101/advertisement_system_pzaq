package com.draczek.SystemOgloszeniowy.jobType.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.EntityNotFoundException;
import java.util.UUID;

/**
 * JobTypeNotFoundException entity not found exception.
 */
public final class JobTypeNotFoundException extends EntityNotFoundException {

  private static final String DEFAULT_CODE = "job_type_not_found";

  public JobTypeNotFoundException(UUID uuid) {
    super(String.format("Could not find Job type with UUID: %s", uuid), DEFAULT_CODE);
  }
}
