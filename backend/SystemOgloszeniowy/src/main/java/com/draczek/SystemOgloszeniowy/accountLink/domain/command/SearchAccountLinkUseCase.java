package com.draczek.SystemOgloszeniowy.accountLink.domain.command;

import com.draczek.SystemOgloszeniowy.accountLink.domain.dto.AccountLinkDto;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

/**
 * Class for searching Account links.
 */
@RequiredArgsConstructor
public class SearchAccountLinkUseCase {
  private final AccountLinkMapper accountLinkMapper;
  private final AccountLinkRepository accountLinkRepository;
  private final SecurityFacade securityFacade;

  /**
   * Method for searching user's account links.
   *
   * @return list of AccountLinkDto
   */
  public List<AccountLinkDto> search() {
    return accountLinkRepository.findAll(specificationForLoggedInAccount()).stream()
        .map(accountLinkMapper::toDto).toList();
  }

  public AccountLinkDto search(UUID uuid) {
    return accountLinkMapper.toDto(accountLinkRepository
        .get(uuid, securityFacade.getLoggedInAccount()));
  }

  private Specification<AccountLink> specificationForLoggedInAccount() {
    return (root, query, cb) -> cb.and(
        cb.equal(root.get(AccountLink_.ACCOUNT),
            securityFacade.getLoggedInUser().getUserDetails().getAccount())
    );
  }
}