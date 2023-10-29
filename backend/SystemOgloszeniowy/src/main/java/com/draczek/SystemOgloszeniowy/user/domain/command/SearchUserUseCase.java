package com.draczek.SystemOgloszeniowy.user.domain.command;

import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import com.draczek.SystemOgloszeniowy.user.domain.dto.UserDto;
import lombok.RequiredArgsConstructor;

/**
 * Class for searching User's related data.
 */
@RequiredArgsConstructor
public class SearchUserUseCase {
  private final UserRepository userRepository;
  private final UserMapper userMapper;
  private final SecurityFacade securityFacade;

  /**
   * Test method.
   *
   * @return Admin UserDto
   */
  public UserDto test() {
    return userMapper.toDto(userRepository.getById(3L));
  }

  /**
   * Method, that returns data about logged in user.
   *
   * @return UserDto
   */
  public UserDto info() {
    return userMapper.toDto(securityFacade.getLoggedInUser().getUserDetails());
  }

  /**
   * Method for getting User instance by its email and status.
   *
   * @param email  user's email
   * @param status status
   * @return User instance
   */
  public User get(String email, StatusEnum status) {
    return userRepository.get(email, status);
  }
}
