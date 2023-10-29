package com.draczek.SystemOgloszeniowy.user.domain.command;

import lombok.RequiredArgsConstructor;

/**
 * Class related to creating Users.
 */
@RequiredArgsConstructor
public class CreateUserUseCase {
  private final UserRepository userRepository;

  /**
   * Service for saving user entities.
   *
   * @param user User to save
   * @return saved user instance
   */
  public User save(User user) {
    return userRepository.saveAndFlush(user);
  }
}
