package com.draczek.SystemOgloszeniowy.workingTimeType.domain.command;

import com.draczek.SystemOgloszeniowy.workingTimeType.domain.dto.CreateWorkingTimeTypeDto;
import com.draczek.SystemOgloszeniowy.workingTimeType.domain.dto.UpdateWorkingTimeTypeDto;
import com.draczek.SystemOgloszeniowy.workingTimeType.domain.dto.WorkingTimeTypeDto;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * WorkingTimeType's package facade.
 */
@Validated
@RequiredArgsConstructor
@Transactional
public class WorkingTimeTypeFacade {
  private final SearchWorkingTimeTypeUseCase searchWorkingTimeTypeUseCase;
  private final CreateWorkingTimeTypeUseCase createWorkingTimeTypeUseCase;
  private final DeleteWorkingTimeTypeUseCase deleteWorkingTimeTypeUseCase;
  private final UpdateWorkingTimeTypeUseCase updateWorkingTimeTypeUseCase;

  /**
   * Method for searching for all available WorkingTimeTypes.
   *
   * @return list of WorkingTimeTypes
   */
  public List<WorkingTimeTypeDto> search() {
    return searchWorkingTimeTypeUseCase.search();
  }

  /**
   * Method for searching WorkingTimeType entity by its UUID.
   *
   * @return WorkingTimeType entity
   */
  public WorkingTimeType getEntity(UUID uuid) {
    return searchWorkingTimeTypeUseCase.getEntity(uuid);
  }

  /**
   * Method for creating WorkingTimeType.
   *
   * @param dto CreateWorkingTimeTypeDto
   * @return WorkingTimeTypeDto
   */
  public WorkingTimeTypeDto create(CreateWorkingTimeTypeDto dto) {
    return createWorkingTimeTypeUseCase.createWorkingTimeTypeDto(dto);
  }

  /**
   * Method for deleting WorkingTimeType by its UUID.
   *
   * @param uuid WorkingTimeType's UUID
   */
  public void delete(UUID uuid) {
    deleteWorkingTimeTypeUseCase.delete(uuid);
  }

  /**
   * Method for updating WorkingTimeType entity by its UUID.
   *
   * @param uuid WorkingTimeType's UUID
   * @param dto  UpdateWorkingTimeTypeDto
   * @return modified WorkingTimeTypeDto
   */
  public WorkingTimeTypeDto update(UUID uuid, UpdateWorkingTimeTypeDto dto) {
    return updateWorkingTimeTypeUseCase.updateDto(uuid, dto);
  }
}
