package com.draczek.SystemOgloszeniowy.jobType.domain.command;

import com.draczek.SystemOgloszeniowy.jobType.domain.dto.CreateJobTypeDto;
import com.draczek.SystemOgloszeniowy.jobType.domain.dto.JobTypeDto;
import com.draczek.SystemOgloszeniowy.jobType.domain.dto.UpdateJobTypeDto;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * JobType's package facade.
 */
@Validated
@RequiredArgsConstructor
@Transactional
public class JobTypeFacade {
  private final SearchJobTypeUseCase searchJobTypeUseCase;
  private final CreateJobTypeUseCase createJobTypeUseCase;
  private final DeleteJobTypeUseCase deleteJobTypeUseCase;
  private final UpdateJobTypeUseCase updateJobTypeUseCase;

  /**
   * Method for searching for all available JobType.
   *
   * @return list of JobType
   */
  public List<JobTypeDto> search() {
    return searchJobTypeUseCase.search();
  }

  /**
   * Method for searching JobType entity by its UUID.
   *
   * @return JobType entity
   */
  public JobType getEntity(UUID uuid) {
    return searchJobTypeUseCase.getEntity(uuid);
  }

  /**
   * Method for creating JobType.
   *
   * @param dto CreateJobTypeDto
   * @return JobTypeDto
   */
  public JobTypeDto create(CreateJobTypeDto dto) {
    return createJobTypeUseCase.createJobTypeDto(dto);
  }

  /**
   * Method for deleting JobType by its UUID.
   *
   * @param uuid JobType's UUID
   */
  public void delete(UUID uuid) {
    deleteJobTypeUseCase.delete(uuid);
  }

  /**
   * Method for updating JobType entity by its UUID.
   *
   * @param uuid JobType's UUID
   * @param dto  UpdateJobTypeDto
   * @return modified JobTypeDto
   */
  public JobTypeDto update(UUID uuid, UpdateJobTypeDto dto) {
    return updateJobTypeUseCase.updateDto(uuid, dto);
  }
}
