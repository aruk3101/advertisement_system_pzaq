package com.draczek.SystemOgloszeniowy.auth.command.domain;

import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.user.domain.command.User;
import com.draczek.SystemOgloszeniowy.user.domain.command.UserFacade;
import com.draczek.SystemOgloszeniowy.userActionToken.domain.command.UserActionToken;
import com.draczek.SystemOgloszeniowy.userActionToken.domain.command.UserActionTokenFacade;
import com.draczek.SystemOgloszeniowy.userActionToken.domain.enumerated.UserActionTokenEnum;
import lombok.RequiredArgsConstructor;

/**
 * Class for stuff related do step one of password reset process.
 */
@RequiredArgsConstructor
public class StepOneResetPasswordUseCase {
  private final UserFacade userFacade;
  private final UserActionTokenFacade userActionTokenFacade;
  private final SendMailUseCase sendMailUseCase;

  /**
   * Method for step one of password reset process.
   *
   * @param email User's email
   */
  public void reset(String email) {
    User user = userFacade.get(email, StatusEnum.ACTIVE);
    if (user != null) {
      createAndSendResetToken(user);
    }
  }

  private void createAndSendResetToken(User user) {
    UserActionToken userActionToken = userActionTokenFacade.create(
        user,
        UserActionTokenEnum.RESET_PASSWORD);
    sendMailUseCase.sendResetPasswordMail(userActionToken);
  }
}
