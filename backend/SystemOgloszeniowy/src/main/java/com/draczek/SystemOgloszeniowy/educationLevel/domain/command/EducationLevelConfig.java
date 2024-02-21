package com.draczek.SystemOgloszeniowy.educationLevel.domain.command;

import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config class for EducationLevelFacade.
 */
@Configuration
public class EducationLevelConfig {
  @Bean
  EducationLevelFacade educationLevelFacade(
      EducationLevelRepository educationLevelRepository,
      SecurityFacade securityFacade
  ) {
    EducationLevelMapper educationLevelMapper = Mappers.getMapper(EducationLevelMapper.class);

    SearchEducationLevelUseCase searchEducationLevelUseCase = new SearchEducationLevelUseCase(
        educationLevelMapper,
        educationLevelRepository);

    CreateEducationLevelUseCase createEducationLevelUseCase = new CreateEducationLevelUseCase(
        securityFacade,
        educationLevelRepository,
        educationLevelMapper);

    DeleteEducationLevelUseCase deleteEducationLevelUseCase = new DeleteEducationLevelUseCase(
        educationLevelRepository);

    UpdateEducationLevelUseCase updateEducationLevelUseCase = new UpdateEducationLevelUseCase(
        educationLevelRepository,
        securityFacade,
        educationLevelMapper);

    return new EducationLevelFacade(
        searchEducationLevelUseCase,
        createEducationLevelUseCase,
        deleteEducationLevelUseCase,
        updateEducationLevelUseCase);
  }
}
