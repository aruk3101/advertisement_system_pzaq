package com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.command;

import com.draczek.SystemOgloszeniowy.accountExperience.domain.command.AccountExperience;
import com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.dto.AccountExperienceDutyDto;
import com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.dto.CreateAccountExperienceDutyDto;
import com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.dto.UpdateAccountExperienceDutyDto;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * Account experience duty's package facade.
 */
@Validated
@RequiredArgsConstructor
@Transactional
public class AccountExperienceDutyFacade {
  private final CreateAccountExperienceDutyUseCase createAccountExperienceDutyUseCase;
  private final DeleteAccountExperienceDutyUseCase deleteAccountExperienceDutyUseCase;
  private final UpdateAccountExperienceDutyUseCase updateAccountExperienceDutyUseCase;

  /**
   * Method for creating AccountExperienceDutyDto.
   *
   * @param dto CreateAccountExperienceDutyDto
   * @return AccountExperienceDutyDto
   */
  public AccountExperienceDutyDto create(CreateAccountExperienceDutyDto dto) {
    return createAccountExperienceDutyUseCase.createDto(dto);
  }

  /**
   * Method for creating AccountExperienceDuties.
   *
   * @param dtos list of CreateAccountExperienceDutyDto
   * @return list of AccountExperienceDuty
   */
  public List<AccountExperienceDuty> create(List<CreateAccountExperienceDutyDto> dtos,
                                            AccountExperience accountExperience) {
    return createAccountExperienceDutyUseCase.create(dtos, accountExperience);
  }

  /**
   * Method for deleting AccountExperienceDuty by its UUID.
   *
   * @param uuid AccountExperienceDuty's UUID
   */
  public void delete(UUID uuid) {
    deleteAccountExperienceDutyUseCase.delete(uuid);
  }

  /**
   * Method for updating AccountEducation entity by its UUID.
   *
   * @param uuid AccountEducation's UUID
   * @param dto  UpdateAccountEducationDto
   * @return modified AccountEducationDto
   */
  public AccountExperienceDutyDto update(UUID uuid, UpdateAccountExperienceDutyDto dto) {
    return updateAccountExperienceDutyUseCase.updateDto(uuid, dto);
  }
}

