package com.draczek.SystemOgloszeniowy.positionLevel.domain.exception;

import com.draczek.SystemOgloszeniowy.common.exception.EntityNotFoundException;
import java.util.UUID;

/**
 * PositionLevelNotFoundException entity not found exception.
 */
public final class PositionLevelNotFoundException extends EntityNotFoundException {

  private static final String DEFAULT_CODE = "position_level_not_found";

  public PositionLevelNotFoundException(UUID uuid) {
    super(String.format("Could not find Position level with UUID: %s", uuid), DEFAULT_CODE);
  }
}
