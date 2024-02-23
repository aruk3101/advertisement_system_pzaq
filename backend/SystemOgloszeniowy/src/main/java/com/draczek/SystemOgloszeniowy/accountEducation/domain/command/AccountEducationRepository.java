package com.draczek.SystemOgloszeniowy.accountEducation.domain.command;

import com.draczek.SystemOgloszeniowy.accountEducation.domain.exception.AccountEducationNotFoundException;
import com.draczek.SystemOgloszeniowy.user.domain.command.Account;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository AccountEducation.
 */
@Repository
public interface AccountEducationRepository extends JpaRepository<AccountEducation, Long>,
    JpaSpecificationExecutor<AccountEducation> {

  Optional<AccountEducation> findOneByUuidAndAccount(UUID uuid, Account account);

  /**
   * Method for fetching AccountEducation by its UUID.
   *
   * @param uuid AccountEducation's UUID
   * @param account owner's account
   * @return found AccountEducation entity
   */
  default AccountEducation get(UUID uuid, Account account) {
    return findOneByUuidAndAccount(uuid, account)
        .orElseThrow(
            () -> new AccountEducationNotFoundException(uuid));
  }
}

