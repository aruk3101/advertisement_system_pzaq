package com.draczek.SystemOgloszeniowy.auth.command.exception;

import com.draczek.SystemOgloszeniowy.common.dto.ViolationDto;
import com.draczek.SystemOgloszeniowy.common.exception.DtoInvalidException;
import java.util.List;

/**
 * Step two password reset process validation failed exception.
 */
public class StepTwoResetPasswordNotValidException extends DtoInvalidException {
  private static final String DEFAULT_CODE = "step_two_reset_password_validation_failed";

  public StepTwoResetPasswordNotValidException(Object dto, List<ViolationDto> violations) {
    super(dto, violations, DEFAULT_CODE);
  }
}
