package com.draczek.SystemOgloszeniowy.workingTimeType.domain.command;

import com.draczek.SystemOgloszeniowy.workingTimeType.domain.exception.WorkingTimeTypeNotFoundException;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository WorkingTimeTypeRepository.
 */
@Repository
public interface WorkingTimeTypeRepository extends JpaRepository<WorkingTimeType, Long>,
    JpaSpecificationExecutor<WorkingTimeType> {

  Optional<WorkingTimeType> findOneByUuid(UUID uuid);

  /**
   * Method for fetching WorkingTimeType by its UUID.
   *
   * @param uuid WorkingTimeType's UUID
   * @return found WorkingTimeType entity
   */
  default WorkingTimeType get(UUID uuid) {
    return findOneByUuid(uuid)
        .orElseThrow(
            () -> new WorkingTimeTypeNotFoundException(uuid));
  }
}
