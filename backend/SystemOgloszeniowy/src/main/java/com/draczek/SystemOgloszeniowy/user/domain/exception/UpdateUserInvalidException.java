package com.draczek.SystemOgloszeniowy.user.domain.exception;

import com.draczek.SystemOgloszeniowy.common.dto.ViolationDto;
import com.draczek.SystemOgloszeniowy.common.exception.DtoInvalidException;
import java.util.List;

/**
 * Invalid UpdateUserDto exception.
 */
public class UpdateUserInvalidException extends DtoInvalidException {
  private static final String DEFAULT_CODE = "user_update_validation_failed";

  public UpdateUserInvalidException(Object dto, List<ViolationDto> violations) {
    super(dto, violations, DEFAULT_CODE);
  }
}
