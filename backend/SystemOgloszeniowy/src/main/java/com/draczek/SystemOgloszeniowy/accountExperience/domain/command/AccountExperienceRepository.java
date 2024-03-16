package com.draczek.SystemOgloszeniowy.accountExperience.domain.command;

import com.draczek.SystemOgloszeniowy.accountExperience.domain.exception.AccountExperienceNotFoundException;
import com.draczek.SystemOgloszeniowy.user.domain.command.Account;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository AccountExperience.
 */
@Repository
public interface AccountExperienceRepository extends JpaRepository<AccountExperience, Long>,
    JpaSpecificationExecutor<AccountExperience> {

  Optional<AccountExperience> findOneByUuidAndAccount(UUID uuid, Account account);

  /**
   * Method for fetching AccountExperience by its UUID.
   *
   * @param uuid AccountExperience's UUID
   * @param account owner's account
   * @return found AccountExperience entity
   */
  default AccountExperience get(UUID uuid, Account account) {
    return findOneByUuidAndAccount(uuid, account)
        .orElseThrow(
            () -> new AccountExperienceNotFoundException(uuid));
  }
}
