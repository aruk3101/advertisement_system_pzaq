package com.draczek.SystemOgloszeniowy.user.domain.command;

import com.draczek.SystemOgloszeniowy.user.domain.dto.UserDto;
import lombok.RequiredArgsConstructor;

/**
 * Class for searching User's related data.
 */
@RequiredArgsConstructor
public class SearchUserUseCase {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  /**
   * Test method.
   *
   * @return Admin UserDto
   */
  public UserDto test() {
    return userMapper.toDto(userRepository.getById(3L));
  }
}
