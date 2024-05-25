package com.draczek.SystemOgloszeniowy.jobType.domain.command;

import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for deleting JobType entities.
 */
@RequiredArgsConstructor
public class DeleteJobTypeUseCase {
  private final JobTypeRepository jobTypeRepository;

  public void delete(UUID uuid) {
    JobType jobType = jobTypeRepository.get(uuid);
    jobTypeRepository.delete(jobType);
  }

}