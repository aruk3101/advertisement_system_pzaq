package com.draczek.SystemOgloszeniowy.auth.command.domain;

import com.draczek.SystemOgloszeniowy.auth.command.dto.RegistrationDto;
import com.draczek.SystemOgloszeniowy.auth.command.exception.RegistrationInvalidException;
import com.draczek.SystemOgloszeniowy.common.dto.ViolationDto;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import com.draczek.SystemOgloszeniowy.user.domain.command.UserFacade;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

/**
 * Helper class for Registration data validation.
 */
@RequiredArgsConstructor
public class RegistrationValidationHelper {
  private final SecurityFacade securityFacade;
  private final UserFacade userFacade;

  /**
   * Method for RegistrationDto validation.
   *
   * @param dto RegistrationDto
   * @throws RegistrationInvalidException violations
   */
  public void validate(@NotNull RegistrationDto dto) throws RegistrationInvalidException {
    List<ViolationDto> violations = new ArrayList<>(
        securityFacade.validatePassword(dto.getPassword(), dto.getConfirmPassword()));

    violations.addAll(userFacade.validate(dto.getUsername()));

    if (!violations.isEmpty()) {
      throw new RegistrationInvalidException(dto, violations);
    }
  }
}
