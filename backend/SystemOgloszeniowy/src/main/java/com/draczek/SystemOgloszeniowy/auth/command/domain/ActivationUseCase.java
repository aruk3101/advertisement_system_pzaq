package com.draczek.SystemOgloszeniowy.auth.command.domain;

import com.draczek.SystemOgloszeniowy.user.domain.command.UserFacade;
import com.draczek.SystemOgloszeniowy.userActionToken.domain.command.UserActionToken;
import com.draczek.SystemOgloszeniowy.userActionToken.domain.command.UserActionTokenFacade;
import com.draczek.SystemOgloszeniowy.userActionToken.domain.enumerated.UserActionTokenDeleteCauseEnum;
import com.draczek.SystemOgloszeniowy.userActionToken.domain.enumerated.UserActionTokenEnum;
import lombok.RequiredArgsConstructor;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

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
        key = URLDecoder.decode(key, StandardCharsets.UTF_8);
        // weird bug - key sent through axios comes up with "=" at the end
        if (key.endsWith("=")) {
            key = key.substring(0, key.length() - 1);
        }
        UserActionToken token = userActionTokenFacade.get(key, UserActionTokenEnum.ACTIVATE_ACCOUNT);
        userFacade.activate(token.getUser());
        userActionTokenFacade.delete(token, UserActionTokenDeleteCauseEnum.USED);
    }
}
