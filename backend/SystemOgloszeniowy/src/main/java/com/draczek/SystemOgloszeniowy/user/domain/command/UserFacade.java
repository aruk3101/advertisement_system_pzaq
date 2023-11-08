package com.draczek.SystemOgloszeniowy.user.domain.command;

import com.draczek.SystemOgloszeniowy.common.dto.ViolationDto;
import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.user.domain.dto.UserDto;
import java.util.List;
import javax.transaction.Transactional;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
  private final CreateUserUseCase createUserUseCase;
  private final UserValidationHelper userValidationHelper;
  private final UpdateUserUseCase updateUserUseCase;

  /**
   * Test method.
   *
   * @return UserDto
   */
  public UserDto test() {
    return searchUserUseCase.test();
  }

  /**
   * Method for getting information about logged-in user.
   *
   * @return UserDto
   */
  public UserDto info() {
    return searchUserUseCase.info();
  }

  /**
   * Method for saving the user in the database.
   *
   * @param user User instance to save
   * @return saved user
   */
  public User save(@NotNull User user) {
    return createUserUseCase.save(user);
  }

  /**
   * Helper service for user validation.
   *
   * @param username user's username
   * @return violations
   */
  public List<ViolationDto> validate(@NotBlank @Email String username) {
    return userValidationHelper.validate(username);
  }

  /**
   * Method for changing User's status to active.
   *
   * @param user user to activate
   */
  public void activate(@NotNull User user) {
    updateUserUseCase.activate(user);
  }

  /**
   * Method for getting User instance by its email and status.
   *
   * @param email  user's email
   * @param status status
   * @return User instance
   */
  public User get(@NotBlank String email, @NotNull StatusEnum status) {
    return searchUserUseCase.get(email, status);
  }

  /**
   * Method for changing user's password.
   *
   * @param user     User to change
   * @param password new password
   */
  public void changePassword(@NotNull User user, @NotBlank String password) {
    updateUserUseCase.changePassword(user, password);
  }
}
