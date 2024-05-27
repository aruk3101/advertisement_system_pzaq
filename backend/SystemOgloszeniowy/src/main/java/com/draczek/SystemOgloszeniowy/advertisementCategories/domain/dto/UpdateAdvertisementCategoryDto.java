package com.draczek.SystemOgloszeniowy.advertisementCategories.domain.dto;

import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * UpdateAdvertisementCategoryDto dto.
 */
@Value
public class UpdateAdvertisementCategoryDto {
  String name;

  @NotNull
  Integer version;
}
