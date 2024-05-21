package com.draczek.SystemOgloszeniowy.workingTimeType.domain.command;

import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for deleting WorkingTimeType entities.
 */
@RequiredArgsConstructor
public class DeleteWorkingTimeTypeUseCase {
  private final WorkingTimeTypeRepository workingTimeTypeRepository;

  public void delete(UUID uuid) {
    WorkingTimeType workingTimeType = workingTimeTypeRepository.get(uuid);
    workingTimeTypeRepository.delete(workingTimeType);
  }
}
