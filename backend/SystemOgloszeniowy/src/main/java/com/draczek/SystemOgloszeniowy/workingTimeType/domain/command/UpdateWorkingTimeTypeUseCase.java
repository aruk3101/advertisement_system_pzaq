package com.draczek.SystemOgloszeniowy.workingTimeType.domain.command;

import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import com.draczek.SystemOgloszeniowy.workingTimeType.domain.dto.UpdateWorkingTimeTypeDto;
import com.draczek.SystemOgloszeniowy.workingTimeType.domain.dto.WorkingTimeTypeDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for updating WorkingTimeTypes.
 */
@RequiredArgsConstructor
public class UpdateWorkingTimeTypeUseCase {
  private final WorkingTimeTypeRepository workingTimeTypeRepository;
  private final SecurityFacade securityFacade;
  private final WorkingTimeTypeMapper workingTimeTypeMapper;

  /**
   * Method for updating WorkingTimeType.
   *
   * @param uuid WorkingTimeType's UUID
   * @param dto  UpdateWorkingTimeTypeDto
   * @return modified WorkingTimeTypeDto
   */
  public WorkingTimeTypeDto updateDto(UUID uuid, UpdateWorkingTimeTypeDto dto) {
    return workingTimeTypeMapper.toDto(update(uuid, dto));
  }

  private WorkingTimeType update(UUID uuid, UpdateWorkingTimeTypeDto dto) {
    WorkingTimeType workingTimeType = workingTimeTypeRepository.get(uuid);
    workingTimeType.setName(dto.getName());
    workingTimeType.setVersion(dto.getVersion());
    workingTimeType.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return workingTimeTypeRepository.saveAndFlush(workingTimeType);
  }
}
