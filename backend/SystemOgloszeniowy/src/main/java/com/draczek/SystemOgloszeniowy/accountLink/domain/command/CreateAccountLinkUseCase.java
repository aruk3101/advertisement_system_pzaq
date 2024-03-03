package com.draczek.SystemOgloszeniowy.accountLink.domain.command;

import com.draczek.SystemOgloszeniowy.accountLink.domain.dto.AccountLinkDto;
import com.draczek.SystemOgloszeniowy.accountLink.domain.dto.CreateAccountLinkDto;
import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for creating Account links.
 */

@RequiredArgsConstructor
public class CreateAccountLinkUseCase {
  private final SecurityFacade securityFacade;
  private final AccountLinkRepository accountLinkRepository;
  private final AccountLinkMapper accountLinkMapper;

  /**
   * Method for creating Account links.
   *
   * @param dto CreateAccountLinkDto
   * @return AccountLinkDto dto
   */
  public AccountLinkDto createDto(CreateAccountLinkDto dto) {
    return accountLinkMapper.toDto(create(dto));
  }

  private AccountLink create(CreateAccountLinkDto dto) {
    AccountLink accountLink = AccountLink.builder()
        .uuid(UUID.randomUUID())
        .name(dto.getName())
        .hyperlink(dto.getHyperlink())
        .account(securityFacade.getLoggedInAccount())
        .build();
    accountLink.setStatus(StatusEnum.ACTIVE);
    accountLink.setUserIdCreated(securityFacade.getLoggedInUser().getId());
    accountLink.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return accountLinkRepository.saveAndFlush(accountLink);
  }
}
