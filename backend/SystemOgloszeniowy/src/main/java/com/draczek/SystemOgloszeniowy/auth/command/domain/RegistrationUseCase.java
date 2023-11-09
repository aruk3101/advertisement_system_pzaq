package com.draczek.SystemOgloszeniowy.auth.command.domain;

import com.draczek.SystemOgloszeniowy.auth.command.dto.RegistrationDto;
import com.draczek.SystemOgloszeniowy.user.domain.command.User;
import com.draczek.SystemOgloszeniowy.user.domain.command.UserFacade;
import com.draczek.SystemOgloszeniowy.userActionToken.domain.command.UserActionToken;
import com.draczek.SystemOgloszeniowy.userActionToken.domain.command.UserActionTokenFacade;
import com.draczek.SystemOgloszeniowy.userActionToken.domain.enumerated.UserActionTokenEnum;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

/**
 * Class for user registration related actions.
 */
@RequiredArgsConstructor
class RegistrationUseCase {

  private final RegistrationValidationHelper validationHelper;
  private final UserFacade userFacade;
  private final UserActionTokenFacade userActionTokenFacade;
  private final SendMailUseCase sendMailUseCase;

  /**
   * Metoda zawierająca implementacje rejestacji nowej firmy i konta administratora.
   */
  public void registration(@NotNull RegistrationDto dto) {
    validationHelper.validate(dto);
    registerUser(dto);
  }

  private void registerUser(RegistrationDto dto) {
    User user = createUser(dto);
    createAndSendActiveToken(user);
  }

  private User createUser(RegistrationDto dto) {
    return userFacade.create(dto);
  }

  private void createAndSendActiveToken(User user) {
    UserActionToken userActionToken = userActionTokenFacade.create(
        user,
        UserActionTokenEnum.ACTIVATE_ACCOUNT);
    sendMailUseCase.sendActivateAccountMail(userActionToken);
  }
}
