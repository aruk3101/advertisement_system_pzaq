package com.draczek.SystemOgloszeniowy.educationLevel.domain.command;

import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for deleting EducationLevel entities.
 */
@RequiredArgsConstructor
public class DeleteEducationLevelUseCase {
  private final EducationLevelRepository educationLevelRepository;

  public void delete(UUID uuid) {
    EducationLevel educationLevel = educationLevelRepository.get(uuid);
    educationLevelRepository.delete(educationLevel);
  }

}
