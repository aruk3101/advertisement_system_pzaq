package com.draczek.SystemOgloszeniowy.accountLink.domain.command;

import com.draczek.SystemOgloszeniowy.accountLink.domain.dto.AccountLinkDto;
import com.draczek.SystemOgloszeniowy.accountLink.domain.dto.CreateAccountLinkDto;
import com.draczek.SystemOgloszeniowy.accountLink.domain.dto.UpdateAccountLinkDto;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * Account link's package facade.
 */
@Validated
@RequiredArgsConstructor
@Transactional
public class AccountLinkFacade {
  private final SearchAccountLinkUseCase searchAccountLinkUseCase;
  private final CreateAccountLinkUseCase createAccountLinkUseCase;
  private final DeleteAccountLinkUseCase deleteAccountLinkUseCase;
  private final UpdateAccountLinkUseCase updateAccountLinkUseCase;

  /**
   * Method for searching for all available AccountLink.
   *
   * @return list of AccountLink
   */
  public List<AccountLinkDto> search() {
    return searchAccountLinkUseCase.search();
  }

  /**
   * Method for searching for AccountLinks by its UUID.
   *
   * @return AccountLink dto
   */
  public AccountLinkDto search(UUID uuid) {
    return searchAccountLinkUseCase.search(uuid);
  }

  /**
   * Method for creating AccountLink.
   *
   * @param dto CreateAccountLinkDto
   * @return AccountLinkDto
   */
  public AccountLinkDto create(CreateAccountLinkDto dto) {
    return createAccountLinkUseCase.createDto(dto);
  }

  /**
   * Method for deleting AccountLink by its UUID.
   *
   * @param uuid AccountLink's UUID
   */
  public void delete(UUID uuid) {
    deleteAccountLinkUseCase.delete(uuid);
  }

  /**
   * Method for updating AccountLink entity by its UUID.
   *
   * @param uuid AccountLink's UUID
   * @param dto  UpdateAccountLinkDto
   * @return modified AccountLinkDto
   */
  public AccountLinkDto update(UUID uuid, UpdateAccountLinkDto dto) {
    return updateAccountLinkUseCase.updateDto(uuid, dto);
  }
}
