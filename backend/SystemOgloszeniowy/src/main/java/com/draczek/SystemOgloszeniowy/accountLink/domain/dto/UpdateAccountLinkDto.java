package com.draczek.SystemOgloszeniowy.accountLink.domain.dto;

import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * UpdateAccountLinkDto dto.
 */
@Value
public class UpdateAccountLinkDto {
  String name;

  String hyperlink;

  @NotNull
  Integer version;
}

