package com.draczek.SystemOgloszeniowy.contractType.domain.command;

import com.draczek.SystemOgloszeniowy.contractType.domain.exception.ContractTypeNotFoundException;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository ContractTypeRepository.
 */
@Repository
public interface ContractTypeRepository extends JpaRepository<ContractType, Long>,
    JpaSpecificationExecutor<ContractType> {

  Optional<ContractType> findOneByUuid(UUID uuid);

  /**
   * Method for fetching ContractType by its UUID.
   *
   * @param uuid ContractType's UUID
   * @return found v entity
   */
  default ContractType get(UUID uuid) {
    return findOneByUuid(uuid)
        .orElseThrow(
            () -> new ContractTypeNotFoundException(uuid));
  }
}
