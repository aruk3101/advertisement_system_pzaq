package com.draczek.SystemOgloszeniowy.company.domain.dto;

import lombok.Value;

/**
 * CreateCompanyDto dto.
 */
@Value
public class CreateCompanyDto {
  String name;

  String iframeHyperlink;

  String description;
}
