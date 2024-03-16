package com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.command;

import com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.exception.AccountExperienceDutyNotFoundException;
import com.draczek.SystemOgloszeniowy.user.domain.command.Account;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository AccountExperienceDuty.
 */
@Repository
public interface AccountExperienceDutyRepository extends JpaRepository<AccountExperienceDuty, Long>,
    JpaSpecificationExecutor<AccountExperienceDuty> {

  Optional<AccountExperienceDuty> findOneByUuidAndAccountExperienceAccount(UUID uuid,
                                                                           Account account);

  /**
   * Method for fetching AccountExperienceDuty by its UUID.
   *
   * @param uuid    AccountExperienceDuty's UUID
   * @param account owner's account
   * @return found AccountExperienceDuty entity
   */
  default AccountExperienceDuty get(UUID uuid, Account account) {
    return findOneByUuidAndAccountExperienceAccount(uuid, account)
        .orElseThrow(
            () -> new AccountExperienceDutyNotFoundException(uuid));
  }
}
