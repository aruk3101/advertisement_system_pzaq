package com.draczek.SystemOgloszeniowy.user.domain.command;

import com.draczek.SystemOgloszeniowy.user.domain.dto.UserDto;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * User's package facade.
 */
@Validated
@RequiredArgsConstructor
@Transactional
public class UserFacade {

  private final SearchUserUseCase searchUserUseCase;

  /**
   * Test method.
   *
   * @return UserDto
   */
  public UserDto test() {
    return searchUserUseCase.test();
  }
}
