package com.draczek.SystemOgloszeniowy.company.domain.dto;

import com.draczek.SystemOgloszeniowy.address.domain.dto.UpdateAddressDto;
import lombok.Value;

/**
 * UpdateCompanyDto dto.
 */
@Value
public class UpdateCompanyDto {
  String name;

  String iframeHyperlink;

  UpdateAddressDto updateAddressDto;

  String description;

  Integer version;
}
