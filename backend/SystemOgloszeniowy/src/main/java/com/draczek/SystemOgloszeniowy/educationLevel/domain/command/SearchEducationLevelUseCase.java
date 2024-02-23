package com.draczek.SystemOgloszeniowy.educationLevel.domain.command;

import com.draczek.SystemOgloszeniowy.educationLevel.domain.dto.EducationLevelDto;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * Class for searching Education Levels.
 */
@RequiredArgsConstructor
public class SearchEducationLevelUseCase {
  private final EducationLevelMapper educationLevelMapper;
  private final EducationLevelRepository educationLevelRepository;

  public List<EducationLevelDto> search() {
    return educationLevelRepository.findAll().stream().map(educationLevelMapper::toDto).toList();
  }

  public EducationLevel search(UUID uuid) {
    return educationLevelRepository.get(uuid);
  }
}
