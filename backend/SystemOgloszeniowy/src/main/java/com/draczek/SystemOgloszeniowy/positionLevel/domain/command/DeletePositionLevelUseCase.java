package com.draczek.SystemOgloszeniowy.positionLevel.domain.command;

import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for deleting PositionLevel entities.
 */
@RequiredArgsConstructor
public class DeletePositionLevelUseCase {
  private final PositionLevelRepository positionLevelRepository;

  public void delete(UUID uuid) {
    PositionLevel positionLevel = positionLevelRepository.get(uuid);
    positionLevelRepository.delete(positionLevel);
  }

}
