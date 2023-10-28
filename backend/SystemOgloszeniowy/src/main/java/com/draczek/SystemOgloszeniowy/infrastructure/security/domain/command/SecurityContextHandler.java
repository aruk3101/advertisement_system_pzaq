package com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command;

import com.draczek.SystemOgloszeniowy.user.domain.command.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Class to ease fetching data from security context.
 */
@RequiredArgsConstructor
class SecurityContextHandler {

  /**
   * Method returning data about logged in user.
   */
  public UserDetailsImpl getLoggedInUser() {
    return (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
  }
}