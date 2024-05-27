package com.draczek.SystemOgloszeniowy.advertisementCategories.domain.dto;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * AdvertisementCategoryDto dto.
 */
@Value
public class AdvertisementCategoryDto {
  UUID uuid;

  String name;

  @NotNull
  Integer version;
}
