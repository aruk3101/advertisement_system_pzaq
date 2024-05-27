package com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.command;

import com.draczek.SystemOgloszeniowy.advertisementResponsibilities.domain.dto.AdvertisementResponsibilityDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

/**
 * Mapper AdvertisementResponsibilityMapper.
 */
@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AdvertisementResponsibilityMapper {
  @Mappings({
  })
  AdvertisementResponsibilityDto toDto(AdvertisementResponsibility advertisementResponsibility);
}
