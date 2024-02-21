package com.draczek.SystemOgloszeniowy.educationLevel.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.EntityNotFoundException;
import java.util.UUID;

/**
 * EducationLevel entity not found exception.
 */
public final class EducationLevelNotFoundException extends EntityNotFoundException {

  private static final String DEFAULT_CODE = "education_level_not_found";

  public EducationLevelNotFoundException(UUID uuid) {
    super(String.format("Could not find Education level with UUID: %s", uuid), DEFAULT_CODE);
  }
}


