package com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.command;

import com.draczek.SystemOgloszeniowy.advertisement.domain.command.AdvertisementFacade;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config class for AdvertisementRequirementFacade.
 */
@Configuration
public class AdvertisementRequirementConfig {
  @Bean
  AdvertisementRequirementFacade advertisementRequirementFacade(
      AdvertisementRequirementRepository advertisementRequirementRepository,
      SecurityFacade securityFacade,
      AdvertisementFacade advertisementFacade
  ) {
    AdvertisementRequirementMapper advertisementRequirementMapper = Mappers.getMapper(AdvertisementRequirementMapper.class);

    SearchAdvertisementRequirementUseCase searchAdvertisementRequirementUseCase = new SearchAdvertisementRequirementUseCase(
        advertisementRequirementMapper,
        advertisementRequirementRepository);

    CreateAdvertisementRequirementUseCase createAdvertisementRequirementUseCase = new CreateAdvertisementRequirementUseCase(
        securityFacade,
        advertisementRequirementRepository,
        advertisementRequirementMapper,
        advertisementFacade);

    DeleteAdvertisementRequirementUseCase deleteAdvertisementRequirementUseCase = new DeleteAdvertisementRequirementUseCase(
        advertisementRequirementRepository);

    UpdateAdvertisementRequirementUseCase updateAdvertisementRequirementUseCase = new UpdateAdvertisementRequirementUseCase(
        advertisementRequirementRepository,
        securityFacade,
        advertisementRequirementMapper);

    return new AdvertisementRequirementFacade(
        searchAdvertisementRequirementUseCase,
        createAdvertisementRequirementUseCase,
        deleteAdvertisementRequirementUseCase,
        updateAdvertisementRequirementUseCase);
  }
}
