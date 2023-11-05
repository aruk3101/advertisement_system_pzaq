package com.draczek.SystemOgloszeniowy.userActionToken.domain.command;

import com.draczek.SystemOgloszeniowy.user.domain.command.User;
import com.draczek.SystemOgloszeniowy.userActionToken.domain.enumerated.UserActionTokenEnum;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Class for stuff related to creating new user action tokens.
 */
@RequiredArgsConstructor
public class CreateUserActionTokenUseCase {

  private final PasswordEncoder passwordEncoder;
  private final UserActionTokenRepository userActionTokenRepository;

  /**
   * Method for creating user action token with provided action.
   *
   * @param user   associated user
   * @param action action
   * @return created UserActionToken instance
   */
  public UserActionToken create(User user, UserActionTokenEnum action) {
    LocalDateTime createdAt = LocalDateTime.now();
    UserActionToken userActionToken = UserActionToken.builder()
        .key(passwordEncoder.encode(
            String.format("%s%h%s",
                user.getUsername(),
                action.getValue(),
                createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")))))
        .user(user)
        .action(action)
        .createdDate(createdAt)
        .build();
    return userActionTokenRepository.saveAndFlush(userActionToken);
  }
}
