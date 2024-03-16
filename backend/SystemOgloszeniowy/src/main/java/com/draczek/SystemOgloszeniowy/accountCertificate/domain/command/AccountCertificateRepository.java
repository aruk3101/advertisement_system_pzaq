package com.draczek.SystemOgloszeniowy.accountCertificate.domain.command;

import com.draczek.SystemOgloszeniowy.accountCertificate.domain.exception.AccountCertificateNotFoundException;
import com.draczek.SystemOgloszeniowy.user.domain.command.Account;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository AccountCertificate.
 */
@Repository
public interface AccountCertificateRepository extends JpaRepository<AccountCertificate, Long>,
    JpaSpecificationExecutor<AccountCertificate> {

  Optional<AccountCertificate> findOneByUuidAndAccount(UUID uuid, Account account);

  /**
   * Method for fetching AccountCertificate by its UUID.
   *
   * @param uuid AccountCertificate's UUID
   * @param account owner's account
   * @return found AccountCertificate entity
   */
  default AccountCertificate get(UUID uuid, Account account) {
    return findOneByUuidAndAccount(uuid, account)
        .orElseThrow(
            () -> new AccountCertificateNotFoundException(uuid));
  }
}

