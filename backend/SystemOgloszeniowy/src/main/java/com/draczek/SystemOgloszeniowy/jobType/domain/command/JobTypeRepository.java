package com.draczek.SystemOgloszeniowy.jobType.domain.command;

import com.draczek.SystemOgloszeniowy.jobType.domain.exception.JobTypeNotFoundException;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Repository JobTypeRepository.
 */
@Repository
public interface JobTypeRepository extends JpaRepository<JobType, Long>,
    JpaSpecificationExecutor<JobType> {

  Optional<JobType> findOneByUuid(UUID uuid);

  /**
   * Method for fetching JobType by its UUID.
   *
   * @param uuid JobType's UUID
   * @return found JobType entity
   */
  default JobType get(UUID uuid) {
    return findOneByUuid(uuid)
        .orElseThrow(
            () -> new JobTypeNotFoundException(uuid));
  }
}
