package com.draczek.SystemOgloszeniowy.accountSkill.domain.command;

import com.draczek.SystemOgloszeniowy.accountSkill.domain.dto.AccountSkillDto;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

/**
 * Class for searching Account skills.
 */
@RequiredArgsConstructor
public class SearchAccountSkillUseCase {
  private final AccountSkillMapper accountSkillMapper;
  private final AccountSkillRepository accountSkillRepository;
  private final SecurityFacade securityFacade;

  /**
   * Method for searching user's account skills.
   *
   * @return list of AccountSkillDto
   */
  public List<AccountSkillDto> search() {
    return accountSkillRepository.findAll(specificationForLoggedInAccount()).stream()
        .map(accountSkillMapper::toDto).toList();
  }

  public AccountSkillDto search(UUID uuid) {
    return accountSkillMapper.toDto(accountSkillRepository
        .get(uuid, securityFacade.getLoggedInAccount()));
  }

  private Specification<AccountSkill> specificationForLoggedInAccount() {
    return (root, query, cb) -> cb.and(
        cb.equal(root.get(AccountSkill_.ACCOUNT),
            securityFacade.getLoggedInUser().getUserDetails().getAccount())
    );
  }
}
