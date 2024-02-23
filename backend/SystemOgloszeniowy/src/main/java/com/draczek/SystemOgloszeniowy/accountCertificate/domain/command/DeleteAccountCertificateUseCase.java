package com.draczek.SystemOgloszeniowy.accountCertificate.domain.command;

import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for deleting AccountCertificate entities.
 */
@RequiredArgsConstructor
public class DeleteAccountCertificateUseCase {
  private final AccountCertificateRepository accountCertificateRepository;
  private final SecurityFacade securityFacade;

  /**
   * Method for deleting AccountEducation by its UUID.
   *
   * @param uuid AccountEducation's UUID
   */
  public void delete(UUID uuid) {
    AccountCertificate accountCertificate = accountCertificateRepository
        .get(uuid, securityFacade.getLoggedInAccount());
    accountCertificateRepository.delete(accountCertificate);
  }

}

