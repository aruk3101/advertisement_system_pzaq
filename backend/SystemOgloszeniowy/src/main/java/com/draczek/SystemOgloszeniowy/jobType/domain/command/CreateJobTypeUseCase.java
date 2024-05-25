package com.draczek.SystemOgloszeniowy.jobType.domain.command;

import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import com.draczek.SystemOgloszeniowy.jobType.domain.dto.CreateJobTypeDto;
import com.draczek.SystemOgloszeniowy.jobType.domain.dto.JobTypeDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for creating JobType.
 */

@RequiredArgsConstructor
public class CreateJobTypeUseCase {
  private final SecurityFacade securityFacade;
  private final JobTypeRepository jobTypeRepository;
  private final JobTypeMapper jobTypeMapper;

  /**
   * Method for creating JobType.
   *
   * @param dto CreateJobTypeDto
   * @return JobTypeDto dto
   */
  public JobTypeDto createJobTypeDto(CreateJobTypeDto dto) {
    return jobTypeMapper.toDto(createJobType(dto));
  }

  private JobType createJobType(CreateJobTypeDto dto) {
    JobType positionLevel = JobType.builder()
        .uuid(UUID.randomUUID())
        .name(dto.getName())
        .build();
    positionLevel.setStatus(StatusEnum.ACTIVE);
    positionLevel.setUserIdCreated(securityFacade.getLoggedInUser().getId());
    positionLevel.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return jobTypeRepository.saveAndFlush(positionLevel);
  }
}
