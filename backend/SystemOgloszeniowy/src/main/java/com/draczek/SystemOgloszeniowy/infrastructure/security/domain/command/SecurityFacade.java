package com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command;

import com.draczek.SystemOgloszeniowy.common.dto.ViolationDto;
import com.draczek.SystemOgloszeniowy.user.domain.command.UserDetailsImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Security related facade.
 */
@Slf4j
@RequiredArgsConstructor
public class SecurityFacade {
  private final SecurityContextHandler securityContextHandler;
  private final PasswordValidationHelper passwordValidationHelper;

  /**
   * Method returning data about logged in user.
   *
   * @return UserDetailsImpl instance
   */
  public UserDetailsImpl getLoggedInUser() {
    return securityContextHandler.getLoggedInUser();
  }

  /**
   * Method for validating passwords.
   *
   * @param password        Password
   * @param confirmPassword Repeated password
   * @return violations
   */
  public List<ViolationDto> validatePassword(String password, String confirmPassword) {
    return passwordValidationHelper.validate(password, confirmPassword);
  }
}