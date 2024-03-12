package com.draczek.SystemOgloszeniowy.accountSkill.domain.command;

import com.draczek.SystemOgloszeniowy.accountSkill.domain.exception.AccountSkillNotFoundException;
import com.draczek.SystemOgloszeniowy.user.domain.command.Account;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository AccountSkillRepository.
 */
@Repository
public interface AccountSkillRepository extends JpaRepository<AccountSkill, Long>,
    JpaSpecificationExecutor<AccountSkill> {

  Optional<AccountSkill> findOneByUuidAndAccount(UUID uuid, Account account);

  /**
   * Method for fetching AccountSkill by its UUID.
   *
   * @param uuid    AccountSkill's UUID
   * @param account owner's account
   * @return found AccountSkill entity
   */
  default AccountSkill get(UUID uuid, Account account) {
    return findOneByUuidAndAccount(uuid, account)
        .orElseThrow(
            () -> new AccountSkillNotFoundException(uuid));
  }
}

