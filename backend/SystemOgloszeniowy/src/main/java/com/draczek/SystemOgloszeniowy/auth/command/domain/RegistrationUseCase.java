package com.draczek.SystemOgloszeniowy.auth.command.domain;

import com.draczek.SystemOgloszeniowy.address.domain.command.Address;
import com.draczek.SystemOgloszeniowy.auth.command.dto.RegistrationDto;
import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.role.domain.command.RoleFacade;
import com.draczek.SystemOgloszeniowy.role.domain.enumerated.RoleEnum;
import com.draczek.SystemOgloszeniowy.user.domain.command.Account;
import com.draczek.SystemOgloszeniowy.user.domain.command.User;
import com.draczek.SystemOgloszeniowy.user.domain.command.UserFacade;
import com.draczek.SystemOgloszeniowy.user.domain.enumerated.SystemUserIdEnum;
import com.draczek.SystemOgloszeniowy.userActionToken.domain.command.UserActionToken;
import com.draczek.SystemOgloszeniowy.userActionToken.domain.command.UserActionTokenFacade;
import com.draczek.SystemOgloszeniowy.userActionToken.domain.enumerated.UserActionTokenEnum;
import java.util.Set;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Class for user registration related actions.
 */
@RequiredArgsConstructor
class RegistrationUseCase {

  private final RegistrationValidationHelper validationHelper;
  private final PasswordEncoder passwordEncoder;
  private final RoleFacade roleFacade;
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
    User user = User.builder()
        .uuid(UUID.randomUUID())
        .enabled(false)
        .username(dto.getUsername())
        .password(passwordEncoder.encode(dto.getPassword()))
        .account(Account.builder()
            .uuid(UUID.randomUUID())
            .address(Address.builder()
                .uuid(UUID.randomUUID())
                .build())
            .build())
        .roles(Set.of(roleFacade.getEntity(RoleEnum.ROLE_USER)))
        .accountNonExpired(true)
        .accountNonLocked(true)
        .credentialsNonExpired(true)
        .build();
    user.getAccount().setUser(user);
    user.getAccount().setStatus(StatusEnum.INACTIVE);
    user.getAccount().getAddress().setStatus(StatusEnum.INACTIVE);
    user.setStatus(StatusEnum.INACTIVE);
    user.setUserIdCreated(SystemUserIdEnum.SYSTEM.getId());
    user.setUserIdLastModified(SystemUserIdEnum.SYSTEM.getId());
    return userFacade.save(user);
  }

  private void createAndSendActiveToken(User user) {
    UserActionToken userActionToken = userActionTokenFacade.create(
        user,
        UserActionTokenEnum.ACTIVATE_ACCOUNT);
    sendMailUseCase.sendActivateAccountMail(userActionToken);
  }
}
