package com.draczek.SystemOgloszeniowy.jobType.domain.command;

import com.draczek.SystemOgloszeniowy.jobType.domain.dto.JobTypeDto;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * Class for searching JobType.
 */
@RequiredArgsConstructor
public class SearchJobTypeUseCase {
  private final JobTypeMapper jobTypeMapper;
  private final JobTypeRepository jobTypeRepository;

  public List<JobTypeDto> search() {
    return jobTypeRepository.findAll().stream().map(jobTypeMapper::toDto).toList();
  }

  public JobType getEntity(UUID uuid) {
    return jobTypeRepository.get(uuid);
  }
}
