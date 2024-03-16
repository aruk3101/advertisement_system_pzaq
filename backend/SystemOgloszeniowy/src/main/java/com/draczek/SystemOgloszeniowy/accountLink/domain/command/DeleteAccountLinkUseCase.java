package com.draczek.SystemOgloszeniowy.accountLink.domain.command;

import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for deleting AccountLink entities.
 */
@RequiredArgsConstructor
public class DeleteAccountLinkUseCase {
  private final AccountLinkRepository accountLinkRepository;
  private final SecurityFacade securityFacade;

  /**
   * Method for deleting AccountLink by its UUID.
   *
   * @param uuid AccountLink's UUID
   */
  public void delete(UUID uuid) {
    AccountLink accountLink = accountLinkRepository
        .get(uuid, securityFacade.getLoggedInAccount());
    accountLinkRepository.delete(accountLink);
  }

}

