package com.draczek.SystemOgloszeniowy.jobType.domain.command;

import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import com.draczek.SystemOgloszeniowy.jobType.domain.dto.JobTypeDto;
import com.draczek.SystemOgloszeniowy.jobType.domain.dto.UpdateJobTypeDto;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for updating JobType.
 */
@RequiredArgsConstructor
public class UpdateJobTypeUseCase {
  private final JobTypeRepository jobTypeRepository;
  private final SecurityFacade securityFacade;
  private final JobTypeMapper jobTypeMapper;

  /**
   * Method for updating JobType.
   *
   * @param uuid JobType's UUID
   * @param dto  UpdateJobTypeDto
   * @return modified JobTypeDto
   */
  public JobTypeDto updateDto(UUID uuid, UpdateJobTypeDto dto) {
    return jobTypeMapper.toDto(update(uuid, dto));
  }

  private JobType update(UUID uuid, UpdateJobTypeDto dto) {
    JobType contractType = jobTypeRepository.get(uuid);
    contractType.setName(dto.getName());
    contractType.setVersion(dto.getVersion());
    contractType.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    return jobTypeRepository.saveAndFlush(contractType);
  }
}
