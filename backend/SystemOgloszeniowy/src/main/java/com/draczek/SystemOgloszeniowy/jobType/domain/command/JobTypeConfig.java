package com.draczek.SystemOgloszeniowy.jobType.domain.command;

import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config class for JobTypeConfig.
 */
@Configuration
public class JobTypeConfig {
  @Bean
  JobTypeFacade jobTypeFacade(
      JobTypeRepository jobTypeRepository,
      SecurityFacade securityFacade
  ) {
    JobTypeMapper jobTypeMapper = Mappers.getMapper(JobTypeMapper.class);

    SearchJobTypeUseCase searchJobTypeUseCase = new SearchJobTypeUseCase(
        jobTypeMapper,
        jobTypeRepository);

    CreateJobTypeUseCase createJobTypeUseCase = new CreateJobTypeUseCase(
        securityFacade,
        jobTypeRepository,
        jobTypeMapper);

    DeleteJobTypeUseCase deleteJobTypeUseCase = new DeleteJobTypeUseCase(
        jobTypeRepository);

    UpdateJobTypeUseCase updateJobTypeUseCase = new UpdateJobTypeUseCase(
        jobTypeRepository,
        securityFacade,
        jobTypeMapper);

    return new JobTypeFacade(
        searchJobTypeUseCase,
        createJobTypeUseCase,
        deleteJobTypeUseCase,
        updateJobTypeUseCase);
  }
}
