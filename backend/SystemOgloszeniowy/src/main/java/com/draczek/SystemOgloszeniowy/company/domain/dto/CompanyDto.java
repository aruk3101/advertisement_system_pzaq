package com.draczek.SystemOgloszeniowy.company.domain.dto;

import com.draczek.SystemOgloszeniowy.address.domain.dto.AddressDto;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * Company dto.
 */
@Value
public class CompanyDto {
  UUID uuid;

  String name;

  String iframeHyperlink;

  AddressDto address;

  String description;

  @NotNull
  Integer version;
}
