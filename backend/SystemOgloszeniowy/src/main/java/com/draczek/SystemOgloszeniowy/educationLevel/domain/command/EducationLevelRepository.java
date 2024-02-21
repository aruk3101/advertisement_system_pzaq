package com.draczek.SystemOgloszeniowy.educationLevel.domain.command;

import com.draczek.SystemOgloszeniowy.educationLevel.domain.exception.EducationLevelNotFoundException;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository EducationLevel.
 */
@Repository
public interface EducationLevelRepository extends JpaRepository<EducationLevel, Long>,
    JpaSpecificationExecutor<EducationLevel> {

  Optional<EducationLevel> findOneByUuid(UUID uuid);

  /**
   * Method for fetching EducationLevel by its UUID.
   *
   * @param uuid EducationLevel's UUID
   * @return found EducationLevel entity
   */
  default EducationLevel get(UUID uuid) {
    return findOneByUuid(uuid)
        .orElseThrow(
            () -> new EducationLevelNotFoundException(uuid));
  }
}
