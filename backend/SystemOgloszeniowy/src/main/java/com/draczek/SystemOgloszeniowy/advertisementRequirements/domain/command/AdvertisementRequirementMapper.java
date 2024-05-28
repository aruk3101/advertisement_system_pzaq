package com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.command;

import com.draczek.SystemOgloszeniowy.advertisementRequirements.domain.dto.AdvertisementRequirementDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

/**
 * Mapper AdvertisementRequirementMapper.
 */
@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AdvertisementRequirementMapper {
  @Mappings({
  })
  AdvertisementRequirementDto toDto(AdvertisementRequirement advertisementRequirement);
}
