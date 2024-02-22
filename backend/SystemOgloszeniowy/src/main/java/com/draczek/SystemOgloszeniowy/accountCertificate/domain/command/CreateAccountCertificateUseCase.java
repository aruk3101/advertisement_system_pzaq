package com.draczek.SystemOgloszeniowy.accountCertificate.domain.command;

import com.draczek.SystemOgloszeniowy.accountCertificate.domain.dto.AccountCertificateDto;
import com.draczek.SystemOgloszeniowy.accountCertificate.domain.dto.CreateAccountCertificateDto;
import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for creating Account certificates.
 */

@RequiredArgsConstructor
public class CreateAccountCertificateUseCase {
  private final SecurityFacade securityFacade;
  private final AccountCertificateRepository accountCertificateRepository;
  private final AccountCertificateMapper accountCertificateMapper;

  /**
   * Method for creating Account certificates.
   *
   * @param dto CreateAccountCertificateDto
   * @return AccountCertificateDto dto
   */
  public AccountCertificateDto createDto(CreateAccountCertificateDto dto) {
    return accountCertificateMapper.toDto(create(dto));
  }

  private AccountCertificate create(CreateAccountCertificateDto dto) {
    AccountCertificate accountCertificate = AccountCertificate.builder()
        .uuid(UUID.randomUUID())
        .name(dto.getName())
        .host(dto.getHost())
        .date(dto.getDate())
        .account(securityFacade.getLoggedInAccount())
        .build();
    accountCertificate.setStatus(StatusEnum.ACTIVE);
    accountCertificate.setUserIdCreated(securityFacade.getLoggedInUser().getId());
    accountCertificate.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return accountCertificateRepository.saveAndFlush(accountCertificate);
  }
}
