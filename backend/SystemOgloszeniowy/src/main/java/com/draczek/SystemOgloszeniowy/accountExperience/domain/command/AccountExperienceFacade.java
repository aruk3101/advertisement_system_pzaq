package com.draczek.SystemOgloszeniowy.accountExperience.domain.command;

import com.draczek.SystemOgloszeniowy.accountExperience.domain.dto.AccountExperienceDto;
import com.draczek.SystemOgloszeniowy.accountExperience.domain.dto.CreateAccountExperienceDto;
import com.draczek.SystemOgloszeniowy.accountExperience.domain.dto.UpdateAccountExperienceDto;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;


/**
 * Account experience's package facade.
 */
@Validated
@RequiredArgsConstructor
@Transactional
public class AccountExperienceFacade {
  private final SearchAccountExperienceUseCase searchAccountExperienceUseCase;
  private final CreateAccountExperienceUseCase createAccountExperienceUseCase;
  private final DeleteAccountExperienceUseCase deleteAccountExperienceUseCase;
  private final UpdateAccountExperienceUseCase updateAccountExperienceUseCase;

  /**
   * Method for searching for all available AccountExperience.
   *
   * @return list of AccountExperienceDto
   */
  public List<AccountExperienceDto> search() {
    return searchAccountExperienceUseCase.search();
  }

  /**
   * Method for searching for AccountExperience by its UUID.
   *
   * @return AccountExperience dto
   */
  public AccountExperienceDto search(UUID uuid) {
    return searchAccountExperienceUseCase.search(uuid);
  }

  /**
   * Method for searching for AccountExperience entity by its UUID.
   *
   * @return AccountExperience entity
   */
  public AccountExperience getEntity(UUID uuid) {
    return searchAccountExperienceUseCase.getEntity(uuid);
  }

  /**
   * Method for creating AccountExperiences.
   *
   * @param dto CreateAccountExperienceDto
   * @return AccountExperienceDto
   */
  public AccountExperienceDto create(CreateAccountExperienceDto dto) {
    return createAccountExperienceUseCase.createDto(dto);
  }

  /**
   * Method for deleting AccountExperience by its UUID.
   *
   * @param uuid AccountExperience's UUID
   */
  public void delete(UUID uuid) {
    deleteAccountExperienceUseCase.delete(uuid);
  }

  /**
   * Method for updating AccountExperience entity by its UUID.
   *
   * @param uuid AccountExperience's UUID
   * @param dto  UpdateAccountExperienceDto
   * @return modified AccountExperienceDto
   */
  public AccountExperienceDto update(UUID uuid, UpdateAccountExperienceDto dto) {
    return updateAccountExperienceUseCase.updateDto(uuid, dto);
  }
}
