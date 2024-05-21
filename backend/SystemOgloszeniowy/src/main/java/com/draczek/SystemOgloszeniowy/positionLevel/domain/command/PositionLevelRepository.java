package com.draczek.SystemOgloszeniowy.positionLevel.domain.command;

import com.draczek.SystemOgloszeniowy.positionLevel.domain.exception.PositionLevelNotFoundException;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository PositionLevelRepository.
 */
@Repository
public interface PositionLevelRepository extends JpaRepository<PositionLevel, Long>,
    JpaSpecificationExecutor<PositionLevel> {

  Optional<PositionLevel> findOneByUuid(UUID uuid);

  /**
   * Method for fetching PositionLevel by its UUID.
   *
   * @param uuid PositionLevel's UUID
   * @return found PositionLevel entity
   */
  default PositionLevel get(UUID uuid) {
    return findOneByUuid(uuid)
        .orElseThrow(
            () -> new PositionLevelNotFoundException(uuid));
  }
}
