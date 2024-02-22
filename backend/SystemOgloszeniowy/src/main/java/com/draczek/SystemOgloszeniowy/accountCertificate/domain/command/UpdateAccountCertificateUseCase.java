package com.draczek.SystemOgloszeniowy.accountCertificate.domain.command;

import com.draczek.SystemOgloszeniowy.accountCertificate.domain.dto.AccountCertificateDto;
import com.draczek.SystemOgloszeniowy.accountCertificate.domain.dto.UpdateAccountCertificateDto;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for updating Account certificates.
 */
@RequiredArgsConstructor
public class UpdateAccountCertificateUseCase {
  private final AccountCertificateRepository accountCertificateRepository;
  private final SecurityFacade securityFacade;
  private final AccountCertificateMapper accountCertificateMapper;

  /**
   * Method for updating AccountCertificates.
   *
   * @param uuid AccountCertificate's UUID
   * @param dto UpdateAccountCertificateDto
   * @return modified AccountCertificateDto
   */
  public AccountCertificateDto updateDto(UUID uuid, UpdateAccountCertificateDto dto) {
    return accountCertificateMapper.toDto(update(uuid, dto));
  }

  private AccountCertificate update(UUID uuid, UpdateAccountCertificateDto dto) {
    AccountCertificate accountCertificate = accountCertificateRepository
        .get(uuid, securityFacade.getLoggedInAccount());
    accountCertificate.setName(dto.getName());
    accountCertificate.setHost(dto.getHost());
    accountCertificate.setDate(dto.getDate());
    accountCertificate.setVersion(dto.getVersion());
    accountCertificate.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return accountCertificateRepository.saveAndFlush(accountCertificate);
  }
}
