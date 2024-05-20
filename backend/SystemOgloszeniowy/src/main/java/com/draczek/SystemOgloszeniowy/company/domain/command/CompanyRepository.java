package com.draczek.SystemOgloszeniowy.company.domain.command;

import com.draczek.SystemOgloszeniowy.company.domain.exception.CompanyNotFoundException;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository Company.
 */
@Repository
interface CompanyRepository extends JpaRepository<Company, Long>,
    JpaSpecificationExecutor<Company> {

  Optional<Company> findOneByUuid(UUID uuid);

  /**
   * Method for fetching Companies.
   *
   * @param uuid UUID
   * @return Company entity
   */
  default Company get(UUID uuid) {
    return findOneByUuid(uuid)
        .orElseThrow(
            () -> new CompanyNotFoundException(uuid));
  }
}
