package com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.command;

import com.draczek.SystemOgloszeniowy.advertisement.domain.command.AdvertisementFacade;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config class for AdvertisementOpportunityFacade.
 */
@Configuration
public class AdvertisementOpportunityConfig {
  @Bean
  AdvertisementOpportunityFacade advertisementOpportunityFacade(
      AdvertisementOpportunityRepository advertisementOpportunityRepository,
      SecurityFacade securityFacade,
      AdvertisementFacade advertisementFacade
  ) {
    AdvertisementOpportunityMapper advertisementOpportunityMapper = Mappers.getMapper(AdvertisementOpportunityMapper.class);

    SearchAdvertisementOpportunityUseCase searchAdvertisementOpportunityUseCase = new SearchAdvertisementOpportunityUseCase(
        advertisementOpportunityMapper,
        advertisementOpportunityRepository);

    CreateAdvertisementOpportunityUseCase createAdvertisementOpportunityUseCase = new CreateAdvertisementOpportunityUseCase(
        securityFacade,
        advertisementOpportunityRepository,
        advertisementOpportunityMapper,
        advertisementFacade);

    DeleteAdvertisementOpportunityUseCase deleteAdvertisementOpportunityUseCase = new DeleteAdvertisementOpportunityUseCase(
        advertisementOpportunityRepository);

    UpdateAdvertisementOpportunityUseCase updateAdvertisementOpportunityUseCase = new UpdateAdvertisementOpportunityUseCase(
        advertisementOpportunityRepository,
        securityFacade,
        advertisementOpportunityMapper);

    return new AdvertisementOpportunityFacade(
        searchAdvertisementOpportunityUseCase,
        createAdvertisementOpportunityUseCase,
        deleteAdvertisementOpportunityUseCase,
        updateAdvertisementOpportunityUseCase);
  }
}
