package com.draczek.SystemOgloszeniowy.accountExperience.domain.command;

import com.draczek.SystemOgloszeniowy.accountExperience.domain.dto.AccountExperienceDto;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

/**
 * Class for searching Account experiences.
 */
@RequiredArgsConstructor
public class SearchAccountExperienceUseCase {
  private final AccountExperienceMapper accountExperienceMapper;
  private final AccountExperienceRepository accountExperienceRepository;
  private final SecurityFacade securityFacade;

  /**
   * Method for searching user's account experiences.
   *
   * @return list of AccountEducationDto
   */
  public List<AccountExperienceDto> search() {
    return accountExperienceRepository.findAll(specificationForLoggedInAccount()).stream()
        .map(accountExperienceMapper::toDto).toList();
  }

  public AccountExperienceDto search(UUID uuid) {
    return accountExperienceMapper.toDto(getEntity(uuid));
  }

  public AccountExperience getEntity(UUID uuid) {
    return accountExperienceRepository.get(uuid, securityFacade.getLoggedInAccount());
  }

  private Specification<AccountExperience> specificationForLoggedInAccount() {
    return (root, query, cb) -> cb.and(
        cb.equal(root.get(AccountExperience_.ACCOUNT),
            securityFacade.getLoggedInUser().getUserDetails().getAccount())
    );
  }
}
