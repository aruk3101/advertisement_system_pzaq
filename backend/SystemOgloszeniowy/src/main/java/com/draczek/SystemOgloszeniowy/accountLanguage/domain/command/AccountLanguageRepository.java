package com.draczek.SystemOgloszeniowy.accountLanguage.domain.command;

import com.draczek.SystemOgloszeniowy.accountLanguage.domain.exception.AccountLanguageNotFoundException;
import com.draczek.SystemOgloszeniowy.user.domain.command.Account;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository AccountLanguage.
 */
@Repository
public interface AccountLanguageRepository extends JpaRepository<AccountLanguage, Long>,
    JpaSpecificationExecutor<AccountLanguage> {

  Optional<AccountLanguage> findOneByUuidAndAccount(UUID uuid, Account account);

  /**
   * Method for fetching AccountLanguage by its UUID.
   *
   * @param uuid AccountLanguage's UUID
   * @param account owner's account
   * @return found AccountLanguage entity
   */
  default AccountLanguage get(UUID uuid, Account account) {
    return findOneByUuidAndAccount(uuid, account)
        .orElseThrow(
            () -> new AccountLanguageNotFoundException(uuid));
  }
}

