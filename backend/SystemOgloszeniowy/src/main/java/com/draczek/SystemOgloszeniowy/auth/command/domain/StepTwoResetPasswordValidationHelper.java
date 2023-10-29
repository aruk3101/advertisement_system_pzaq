package com.draczek.SystemOgloszeniowy.auth.command.domain;

import com.draczek.SystemOgloszeniowy.auth.command.exception.StepTwoResetPasswordNotValidException;
import com.draczek.SystemOgloszeniowy.common.dto.ViolationDto;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;

/**
 * Helper class for StepTwoPasswordResetDto validation.
 */
@RequiredArgsConstructor
public class StepTwoResetPasswordValidationHelper {
  private final SecurityFacade securityFacade;

  /**
   * Helper method for StepTwoPasswordResetDto validation.
   *
   * @param password        new password
   * @param confirmPassword new password repeated
   */
  public void validate(String password, String confirmPassword) {
    List<ViolationDto> violations = new ArrayList<>(
        securityFacade.validatePassword(password, confirmPassword));

    if (!violations.isEmpty()) {
      throw new StepTwoResetPasswordNotValidException(password, violations);
    }
  }
}
