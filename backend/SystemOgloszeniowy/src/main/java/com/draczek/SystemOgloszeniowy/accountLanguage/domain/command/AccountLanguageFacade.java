package com.draczek.SystemOgloszeniowy.accountLanguage.domain.command;

import com.draczek.SystemOgloszeniowy.accountLanguage.domain.dto.AccountLanguageDto;
import com.draczek.SystemOgloszeniowy.accountLanguage.domain.dto.CreateAccountLanguageDto;
import com.draczek.SystemOgloszeniowy.accountLanguage.domain.dto.UpdateAccountLanguageDto;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * Account language's package facade.
 */
@Validated
@RequiredArgsConstructor
@Transactional
public class AccountLanguageFacade {
  private final SearchAccountLanguageUseCase searchAccountLanguageUseCase;
  private final CreateAccountLanguageUseCase createAccountLanguageUseCase;
  private final DeleteAccountLanguageUseCase deleteAccountLanguageUseCase;
  private final UpdateAccountLanguageUseCase updateAccountLanguageUseCase;

  /**
   * Method for searching for all available AccountLanguages.
   *
   * @return list of AccountLanguageDto
   */
  public List<AccountLanguageDto> search() {
    return searchAccountLanguageUseCase.search();
  }

  /**
   * Method for searching for AccountLanguages by its UUID.
   *
   * @return AccountLanguage dto
   */
  public AccountLanguageDto search(UUID uuid) {
    return searchAccountLanguageUseCase.search(uuid);
  }

  /**
   * Method for creating AccountLanguage.
   *
   * @param dto CreateAccountLanguageDto
   * @return AccountLanguageDto
   */
  public AccountLanguageDto create(CreateAccountLanguageDto dto) {
    return createAccountLanguageUseCase.createDto(dto);
  }

  /**
   * Method for deleting AccountLanguage by its UUID.
   *
   * @param uuid AccountLanguage's UUID
   */
  public void delete(UUID uuid) {
    deleteAccountLanguageUseCase.delete(uuid);
  }

  /**
   * Method for updating AccountLanguage entity by its UUID.
   *
   * @param uuid AccountLanguage's UUID
   * @param dto  UpdateAccountLanguageDto
   * @return modified AccountLanguageDto
   */
  public AccountLanguageDto update(UUID uuid, UpdateAccountLanguageDto dto) {
    return updateAccountLanguageUseCase.updateDto(uuid, dto);
  }
}
