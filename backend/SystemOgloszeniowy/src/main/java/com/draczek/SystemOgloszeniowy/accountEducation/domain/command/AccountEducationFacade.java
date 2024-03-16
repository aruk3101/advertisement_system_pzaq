package com.draczek.SystemOgloszeniowy.accountEducation.domain.command;

import com.draczek.SystemOgloszeniowy.accountEducation.domain.dto.AccountEducationDto;
import com.draczek.SystemOgloszeniowy.accountEducation.domain.dto.CreateAccountEducationDto;
import com.draczek.SystemOgloszeniowy.accountEducation.domain.dto.UpdateAccountEducationDto;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * Account education's package facade.
 */
@Validated
@RequiredArgsConstructor
@Transactional
public class AccountEducationFacade {
  private final SearchAccountEducationUseCase searchAccountEducationUseCase;
  private final CreateAccountEducationUseCase createAccountEducationUseCase;
  private final DeleteAccountEducationsUseCase deleteAccountEducationsUseCase;
  private final UpdateAccountEducationUseCase updateAccountEducationUseCase;

  /**
   * Method for searching for all available AccountEducation.
   *
   * @return list of AccountEducationDto
   */
  public List<AccountEducationDto> search() {
    return searchAccountEducationUseCase.search();
  }

  /**
   * Method for searching for AccountEducations by its UUID.
   *
   * @return AccountEducation dto
   */
  public AccountEducationDto search(UUID uuid) {
    return searchAccountEducationUseCase.search(uuid);
  }

  /**
   * Method for creating AccountEducation.
   *
   * @param dto CreateAccountEducationDto
   * @return AccountEducationDto
   */
  public AccountEducationDto create(CreateAccountEducationDto dto) {
    return createAccountEducationUseCase.createDto(dto);
  }

  /**
   * Method for deleting AccountEducation by its UUID.
   *
   * @param uuid AccountEducation's UUID
   */
  public void delete(UUID uuid) {
    deleteAccountEducationsUseCase.delete(uuid);
  }

  /**
   * Method for updating AccountEducation entity by its UUID.
   *
   * @param uuid AccountEducation's UUID
   * @param dto  UpdateAccountEducationDto
   * @return modified AccountEducationDto
   */
  public AccountEducationDto update(UUID uuid, UpdateAccountEducationDto dto) {
    return updateAccountEducationUseCase.updateDto(uuid, dto);
  }
}
