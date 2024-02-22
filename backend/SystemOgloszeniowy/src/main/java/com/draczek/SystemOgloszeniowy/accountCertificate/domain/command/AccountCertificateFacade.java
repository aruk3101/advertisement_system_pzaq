package com.draczek.SystemOgloszeniowy.accountCertificate.domain.command;

import com.draczek.SystemOgloszeniowy.accountCertificate.domain.dto.AccountCertificateDto;
import com.draczek.SystemOgloszeniowy.accountCertificate.domain.dto.CreateAccountCertificateDto;
import com.draczek.SystemOgloszeniowy.accountCertificate.domain.dto.UpdateAccountCertificateDto;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * Account certificate's package facade.
 */
@Validated
@RequiredArgsConstructor
@Transactional
public class AccountCertificateFacade {
  private final SearchAccountCertificateUseCase searchLanguageLevelUseCase;
  private final CreateAccountCertificateUseCase createLanguageLevelUseCase;
  private final DeleteAccountCertificateUseCase deleteLanguageLevelUseCase;
  private final UpdateAccountCertificateUseCase updateAccountCertificateUseCase;

  /**
   * Method for searching for all available AccountCertificate.
   *
   * @return list of AccountCertificate
   */
  public List<AccountCertificateDto> search() {
    return searchLanguageLevelUseCase.search();
  }

  /**
   * Method for searching for AccountCertificates by its UUID.
   *
   * @return LanguageLevels dto
   */
  public AccountCertificateDto search(UUID uuid) {
    return searchLanguageLevelUseCase.search(uuid);
  }

  /**
   * Method for creating AccountCertificate.
   *
   * @param dto CreateAccountCertificateDto
   * @return AccountCertificateDto
   */
  public AccountCertificateDto create(CreateAccountCertificateDto dto) {
    return createLanguageLevelUseCase.createDto(dto);
  }

  /**
   * Method for deleting AccountCertificate by its UUID.
   *
   * @param uuid AccountCertificate's UUID
   */
  public void delete(UUID uuid) {
    deleteLanguageLevelUseCase.delete(uuid);
  }

  /**
   * Method for updating AccountCertificate entity by its UUID.
   *
   * @param uuid AccountCertificate's UUID
   * @param dto  UpdateAccountCertificateDto
   * @return modified AccountCertificateDto
   */
  public AccountCertificateDto update(UUID uuid, UpdateAccountCertificateDto dto) {
    return updateAccountCertificateUseCase.updateDto(uuid, dto);
  }
}
