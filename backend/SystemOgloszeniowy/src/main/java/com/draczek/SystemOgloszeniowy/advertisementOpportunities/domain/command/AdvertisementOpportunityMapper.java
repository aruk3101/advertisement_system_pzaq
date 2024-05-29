package com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.command;

import com.draczek.SystemOgloszeniowy.advertisementOpportunities.domain.dto.AdvertisementOpportunityDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

/**
 * Mapper AdvertisementOpportunityMapper.
 */
@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AdvertisementOpportunityMapper {
  @Mappings({
  })
  AdvertisementOpportunityDto toDto(AdvertisementOpportunity advertisementOpportunity);
}
