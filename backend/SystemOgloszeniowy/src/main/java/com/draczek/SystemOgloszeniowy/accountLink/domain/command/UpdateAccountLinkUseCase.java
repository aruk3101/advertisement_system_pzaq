package com.draczek.SystemOgloszeniowy.accountLink.domain.command;

import com.draczek.SystemOgloszeniowy.accountLink.domain.dto.AccountLinkDto;
import com.draczek.SystemOgloszeniowy.accountLink.domain.dto.UpdateAccountLinkDto;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for updating Account links.
 */
@RequiredArgsConstructor
public class UpdateAccountLinkUseCase {
  private final AccountLinkRepository accountLinkRepository;
  private final SecurityFacade securityFacade;
  private final AccountLinkMapper accountLinkMapper;

  /**
   * Method for updating AccountLinks.
   *
   * @param uuid AccountLink's UUID
   * @param dto UpdateAccountLinkDto
   * @return modified AccountLinkDto
   */
  public AccountLinkDto updateDto(UUID uuid, UpdateAccountLinkDto dto) {
    return accountLinkMapper.toDto(update(uuid, dto));
  }

  private AccountLink update(UUID uuid, UpdateAccountLinkDto dto) {
    AccountLink accountLink = accountLinkRepository
        .get(uuid, securityFacade.getLoggedInAccount());
    accountLink.setName(dto.getName());
    accountLink.setHyperlink(dto.getHyperlink());
    accountLink.setVersion(dto.getVersion());
    accountLink.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return accountLinkRepository.saveAndFlush(accountLink);
  }
}
