package com.draczek.SystemOgloszeniowy.workingTimeType.domain.command;

import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config class for WorkingTimeTypeFacade.
 */
@Configuration
public class WorkingTimeTypeConfig {
  @Bean
  WorkingTimeTypeFacade workingTimeTypeFacade(
      WorkingTimeTypeRepository workingTimeTypeRepository,
      SecurityFacade securityFacade
  ) {
    WorkingTimeTypeMapper positionLevelMapper = Mappers.getMapper(WorkingTimeTypeMapper.class);

    SearchWorkingTimeTypeUseCase searchWorkingTimeTypeUseCase = new SearchWorkingTimeTypeUseCase(
        positionLevelMapper,
        workingTimeTypeRepository);

    CreateWorkingTimeTypeUseCase createWorkingTimeTypeUseCase = new CreateWorkingTimeTypeUseCase(
        securityFacade,
        workingTimeTypeRepository,
        positionLevelMapper);

    DeleteWorkingTimeTypeUseCase deleteWorkingTimeTypeUseCase = new DeleteWorkingTimeTypeUseCase(
        workingTimeTypeRepository);

    UpdateWorkingTimeTypeUseCase updateWorkingTimeTypeUseCase = new UpdateWorkingTimeTypeUseCase(
        workingTimeTypeRepository,
        securityFacade,
        positionLevelMapper);

    return new WorkingTimeTypeFacade(
        searchWorkingTimeTypeUseCase,
        createWorkingTimeTypeUseCase,
        deleteWorkingTimeTypeUseCase,
        updateWorkingTimeTypeUseCase);
  }
}
