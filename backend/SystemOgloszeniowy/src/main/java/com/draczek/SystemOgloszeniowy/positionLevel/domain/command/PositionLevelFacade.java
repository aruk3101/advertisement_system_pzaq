package com.draczek.SystemOgloszeniowy.positionLevel.domain.command;

import com.draczek.SystemOgloszeniowy.positionLevel.domain.dto.CreatePositionLevelDto;
import com.draczek.SystemOgloszeniowy.positionLevel.domain.dto.PositionLevelDto;
import com.draczek.SystemOgloszeniowy.positionLevel.domain.dto.UpdatePositionLevelDto;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * Position Level's package facade.
 */
@Validated
@RequiredArgsConstructor
@Transactional
public class PositionLevelFacade {
  private final SearchPositionLevelUseCase searchPositionLevelUseCase;
  private final CreatePositionLevelUseCase createPositionLevelUseCase;
  private final DeletePositionLevelUseCase deletePositionLevelUseCase;
  private final UpdatePositionLevelUseCase updatePositionLevelUseCase;

  /**
   * Method for searching for all available PositionLevels.
   *
   * @return list of PositionLevels
   */
  public List<PositionLevelDto> search() {
    return searchPositionLevelUseCase.search();
  }

  /**
   * Method for searching PositionLevel entity by its UUID.
   *
   * @return PositionLevel entity
   */
  public PositionLevel getEntity(UUID uuid) {
    return searchPositionLevelUseCase.getEntity(uuid);
  }

  /**
   * Method for creating PositionLevels.
   *
   * @param dto CreatePositionLevelDto
   * @return PositionLevelDto
   */
  public PositionLevelDto create(CreatePositionLevelDto dto) {
    return createPositionLevelUseCase.createPositionLevelDto(dto);
  }

  /**
   * Method for deleting PositionLevel by its UUID.
   *
   * @param uuid PositionLevel's UUID
   */
  public void delete(UUID uuid) {
    deletePositionLevelUseCase.delete(uuid);
  }

  /**
   * Method for updating PositionLevel entity by its UUID.
   *
   * @param uuid PositionLevel's UUID
   * @param dto  UpdatePositionLevelDto
   * @return modified PositionLevelDto
   */
  public PositionLevelDto update(UUID uuid, UpdatePositionLevelDto dto) {
    return updatePositionLevelUseCase.updateDto(uuid, dto);
  }
}
