package com.draczek.SystemOgloszeniowy.advertisementCategories.domain.command;

import com.draczek.SystemOgloszeniowy.advertisementCategories.domain.dto.AdvertisementCategoryDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

/**
 * Mapper AdvertisementCategoryMapper.
 */
@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AdvertisementCategoryMapper {
  @Mappings({
  })
  AdvertisementCategoryDto toDto(AdvertisementCategory advertisementCategory);
}
