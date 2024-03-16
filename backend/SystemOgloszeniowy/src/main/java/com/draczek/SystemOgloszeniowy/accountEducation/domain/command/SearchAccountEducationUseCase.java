package com.draczek.SystemOgloszeniowy.accountEducation.domain.command;

import com.draczek.SystemOgloszeniowy.accountEducation.domain.dto.AccountEducationDto;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

/**
 * Class for searching Account educations.
 */
@RequiredArgsConstructor
public class SearchAccountEducationUseCase {
  private final AccountEducationMapper accountEducationMapper;
  private final AccountEducationRepository accountEducationRepository;
  private final SecurityFacade securityFacade;

  /**
   * Method for searching user's account educations.
   *
   * @return list of AccountEducationDto
   */
  public List<AccountEducationDto> search() {
    return accountEducationRepository.findAll(specificationForLoggedInAccount()).stream()
        .map(accountEducationMapper::toDto).toList();
  }

  public AccountEducationDto search(UUID uuid) {
    return accountEducationMapper.toDto(accountEducationRepository
        .get(uuid, securityFacade.getLoggedInAccount()));
  }

  private Specification<AccountEducation> specificationForLoggedInAccount() {
    return (root, query, cb) -> cb.and(
        cb.equal(root.get(AccountEducation_.ACCOUNT),
            securityFacade.getLoggedInUser().getUserDetails().getAccount())
    );
  }
}
