package com.draczek.SystemOgloszeniowy.jobType.domain.command;

import com.draczek.SystemOgloszeniowy.jobType.domain.dto.JobTypeDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

/**
 * Mapper JobTypeMapper.
 */
@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface JobTypeMapper {
  @Mappings({
  })
  JobTypeDto toDto(JobType jobType);
}
