package com.draczek.SystemOgloszeniowy.accountLanguage.domain.command;

import com.draczek.SystemOgloszeniowy.accountLanguage.domain.dto.AccountLanguageDto;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

/**
 * Class for searching Account languages.
 */
@RequiredArgsConstructor
public class SearchAccountLanguageUseCase {
  private final AccountLanguageMapper accountLanguageMapper;
  private final AccountLanguageRepository accountLanguageRepository;
  private final SecurityFacade securityFacade;

  /**
   * Method for searching user's account languages.
   *
   * @return list of AccountEducationDto
   */
  public List<AccountLanguageDto> search() {
    return accountLanguageRepository.findAll(specificationForLoggedInAccount()).stream()
        .map(accountLanguageMapper::toDto).toList();
  }

  public AccountLanguageDto search(UUID uuid) {
    return accountLanguageMapper.toDto(accountLanguageRepository
        .get(uuid, securityFacade.getLoggedInAccount()));
  }

  private Specification<AccountLanguage> specificationForLoggedInAccount() {
    return (root, query, cb) -> cb.and(
        cb.equal(root.get(AccountLanguage_.ACCOUNT),
            securityFacade.getLoggedInUser().getUserDetails().getAccount())
    );
  }
}
