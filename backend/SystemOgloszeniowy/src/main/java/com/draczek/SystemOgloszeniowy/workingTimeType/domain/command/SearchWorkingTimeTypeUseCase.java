package com.draczek.SystemOgloszeniowy.workingTimeType.domain.command;

import com.draczek.SystemOgloszeniowy.workingTimeType.domain.dto.WorkingTimeTypeDto;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * Class for searching WorkingTimeType.
 */
@RequiredArgsConstructor
public class SearchWorkingTimeTypeUseCase {
  private final WorkingTimeTypeMapper workingTimeTypeMapper;
  private final WorkingTimeTypeRepository workingTimeTypeRepository;

  public List<WorkingTimeTypeDto> search() {
    return workingTimeTypeRepository.findAll().stream().map(workingTimeTypeMapper::toDto).toList();
  }

  public WorkingTimeType getEntity(UUID uuid) {
    return workingTimeTypeRepository.get(uuid);
  }
}
