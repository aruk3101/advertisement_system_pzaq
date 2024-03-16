package com.draczek.SystemOgloszeniowy.accountSkill.domain.command;

import com.draczek.SystemOgloszeniowy.accountSkill.domain.dto.AccountSkillDto;
import com.draczek.SystemOgloszeniowy.accountSkill.domain.dto.CreateAccountSkillDto;
import com.draczek.SystemOgloszeniowy.accountSkill.domain.dto.UpdateAccountSkillDto;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * Account skill's package facade.
 */
@Validated
@RequiredArgsConstructor
@Transactional
public class AccountSkillFacade {
  private final SearchAccountSkillUseCase searchAccountSkillUseCase;
  private final CreateAccountSkillUseCase createAccountSkillUseCase;
  private final DeleteAccountSkillUseCase deleteAccountSkillUseCase;
  private final UpdateAccountSkillUseCase updateAccountSkillUseCase;

  /**
   * Method for searching for all available AccountSkills.
   *
   * @return list of AccountSkill
   */
  public List<AccountSkillDto> search() {
    return searchAccountSkillUseCase.search();
  }

  /**
   * Method for searching for AccountSkill by its UUID.
   *
   * @return AccountSkill dto
   */
  public AccountSkillDto search(UUID uuid) {
    return searchAccountSkillUseCase.search(uuid);
  }

  /**
   * Method for creating AccountSkill.
   *
   * @param dto CreateAccountSkillDto
   * @return AccountSkillDto
   */
  public AccountSkillDto create(CreateAccountSkillDto dto) {
    return createAccountSkillUseCase.createDto(dto);
  }

  /**
   * Method for deleting AccountSkill by its UUID.
   *
   * @param uuid AccountSkill's UUID
   */
  public void delete(UUID uuid) {
    deleteAccountSkillUseCase.delete(uuid);
  }

  /**
   * Method for updating AccountSkill entity by its UUID.
   *
   * @param uuid AccountSkill's UUID
   * @param dto  UpdateAccountSkillDto
   * @return modified AccountSkillDto
   */
  public AccountSkillDto update(UUID uuid, UpdateAccountSkillDto dto) {
    return updateAccountSkillUseCase.updateDto(uuid, dto);
  }
}
