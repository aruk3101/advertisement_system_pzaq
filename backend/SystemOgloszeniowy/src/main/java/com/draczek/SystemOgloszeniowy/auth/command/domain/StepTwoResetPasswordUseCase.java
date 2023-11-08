package com.draczek.SystemOgloszeniowy.auth.command.domain;

import com.draczek.SystemOgloszeniowy.auth.command.dto.ResetPasswordStepTwoDto;
import com.draczek.SystemOgloszeniowy.user.domain.command.UserFacade;
import com.draczek.SystemOgloszeniowy.userActionToken.domain.command.UserActionToken;
import com.draczek.SystemOgloszeniowy.userActionToken.domain.command.UserActionTokenFacade;
import com.draczek.SystemOgloszeniowy.userActionToken.domain.enumerated.UserActionTokenDeleteCauseEnum;
import com.draczek.SystemOgloszeniowy.userActionToken.domain.enumerated.UserActionTokenEnum;
import lombok.RequiredArgsConstructor;

/**
 * Class for stuff related do step two of password reset process.
 */
@RequiredArgsConstructor
class StepTwoResetPasswordUseCase {
  private final StepTwoResetPasswordValidationHelper validationHelper;
  private final UserFacade userFacade;
  private final UserActionTokenFacade userActionTokenFacade;

  /**
   * Method for step two of password reset process.
   */
  public void reset(ResetPasswordStepTwoDto dto) {
    UserActionToken userActionToken = userActionTokenFacade.get(dto.getKey(),
        UserActionTokenEnum.RESET_PASSWORD);
    validationHelper.validate(dto.getPassword(), dto.getConfirmPassword());
    userFacade.changePassword(userActionToken.getUser(), dto.getPassword());
    userActionTokenFacade.delete(userActionToken, UserActionTokenDeleteCauseEnum.USED);
  }
}
