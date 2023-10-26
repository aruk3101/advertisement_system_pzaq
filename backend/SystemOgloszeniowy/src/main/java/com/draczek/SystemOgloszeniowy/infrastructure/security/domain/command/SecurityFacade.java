package com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command;

import com.draczek.SystemOgloszeniowy.user.domain.command.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Security related facade.
 */
@Slf4j
@RequiredArgsConstructor
public class SecurityFacade {
  private final SecurityContextHandler securityContextHandler;

  /**
   * Method returning data about logged in user.
   */
  public UserDetailsImpl getLoggedInUser() {
    return securityContextHandler.getLoggedInUser();
  }
}