package com.draczek.SystemOgloszeniowy.address.domain.command;

import com.draczek.SystemOgloszeniowy.common.exception.EntityNotFoundException;
import com.draczek.SystemOgloszeniowy.company.domain.command.Company;
import com.draczek.SystemOgloszeniowy.company.domain.exception.CompanyNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository AddressRepository.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long>,
    JpaSpecificationExecutor<Address> {
  Optional<Address> findOneByUuid(UUID uuid);

  /**
   * Method for fetching Address.
   *
   * @param uuid UUID
   * @return Address entity
   */
  default Address get(UUID uuid) {
    return findOneByUuid(uuid)
        .orElseThrow(
            () -> new EntityNotFoundException("Could not find Address with uuid: " + uuid));
  }
}

