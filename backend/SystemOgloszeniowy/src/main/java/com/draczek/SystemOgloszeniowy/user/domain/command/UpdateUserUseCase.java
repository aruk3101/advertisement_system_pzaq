package com.draczek.SystemOgloszeniowy.user.domain.command;

import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.user.domain.enumerated.SystemUserIdEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Class for stuff related to updating User entity.
 */
@RequiredArgsConstructor
class UpdateUserUseCase {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  /**
   * Method for changing User's status to active.
   *
   * @param user user to activate
   */
  public void activate(User user) {
    user.setStatus(StatusEnum.ACTIVE);
    user.getAccount().setStatus(StatusEnum.ACTIVE);
    user.getAccount().getAddress().setStatus(StatusEnum.ACTIVE);
    user.setEnabled(true);
    user.setUserIdLastModified(SystemUserIdEnum.SYSTEM.getId());
    userRepository.save(user);
  }

  /**
   * Method for changing user's password after step two of password reset process.
   *
   * @param user     User to change
   * @param password new password
   */
  public void changePassword(User user, String password) {
    // no need of validation here, because password is validated before in StepTwo...UseCase
    user.setPassword(passwordEncoder.encode(password));
    user.setUserIdLastModified(user.getId());
    userRepository.saveAndFlush(user);
  }
}
