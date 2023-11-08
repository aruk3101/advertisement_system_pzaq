package com.draczek.SystemOgloszeniowy.user.domain.command;

import com.draczek.SystemOgloszeniowy.common.dto.ViolationDto;
import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;

/**
 * Helper class for User validation.
 */
@RequiredArgsConstructor
class UserValidationHelper {
  private final UserRepository userRepository;

  /**
   * Helper method for User's username uniqueness validation.
   *
   * @param username User's username
   * @return violations
   */
  public List<ViolationDto> validate(String username) {
    List<ViolationDto> violations = new ArrayList<>();
    if (userExists(username)) {
      violations.add(new ViolationDto(
          "username_taken",
          "usernameTaken",
          "Użytkownik z takim emailem już istnieje"));
    }
    return violations;
  }

  private boolean userExists(String username) {
    return userRepository.findOneByUsernameAndStatus(username, StatusEnum.ACTIVE).isPresent();
  }
}
