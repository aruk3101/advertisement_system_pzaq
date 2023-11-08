package com.draczek.SystemOgloszeniowy.auth.command.domain;

import com.draczek.SystemOgloszeniowy.user.domain.command.UserFacade;
import com.draczek.SystemOgloszeniowy.userActionToken.domain.command.UserActionToken;
import com.draczek.SystemOgloszeniowy.userActionToken.domain.command.UserActionTokenFacade;
import com.draczek.SystemOgloszeniowy.userActionToken.domain.enumerated.UserActionTokenDeleteCauseEnum;
import com.draczek.SystemOgloszeniowy.userActionToken.domain.enumerated.UserActionTokenEnum;
import lombok.RequiredArgsConstructor;

/**
 * Class for activation of new, inactive user.
 */
@RequiredArgsConstructor
class ActivationUseCase {

  private final UserActionTokenFacade userActionTokenFacade;
  private final UserFacade userFacade;

  /**
   * Method for activation of new, inactive user.
   *
   * @param key token key
   */
  public void activate(String key) {
    UserActionToken token = userActionTokenFacade.get(key, UserActionTokenEnum.ACTIVATE_ACCOUNT);
    userFacade.activate(token.getUser());
    userActionTokenFacade.delete(token, UserActionTokenDeleteCauseEnum.USED);
  }
}
