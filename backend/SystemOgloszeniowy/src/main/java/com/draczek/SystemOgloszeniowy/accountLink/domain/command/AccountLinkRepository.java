package com.draczek.SystemOgloszeniowy.accountLink.domain.command;

import com.draczek.SystemOgloszeniowy.accountLink.domain.exception.AccountLinkNotFoundException;
import com.draczek.SystemOgloszeniowy.user.domain.command.Account;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository AccountLinkRepository.
 */
@Repository
public interface AccountLinkRepository extends JpaRepository<AccountLink, Long>,
    JpaSpecificationExecutor<AccountLink> {

  Optional<AccountLink> findOneByUuidAndAccount(UUID uuid, Account account);

  /**
   * Method for fetching AccountLink by its UUID.
   *
   * @param uuid AccountLink's UUID
   * @param account owner's account
   * @return found AccountLink entity
   */
  default AccountLink get(UUID uuid, Account account) {
    return findOneByUuidAndAccount(uuid, account)
        .orElseThrow(
            () -> new AccountLinkNotFoundException(uuid));
  }
}

