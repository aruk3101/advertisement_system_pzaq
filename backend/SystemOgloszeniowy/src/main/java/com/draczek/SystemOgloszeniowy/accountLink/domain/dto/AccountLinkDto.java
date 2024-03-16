package com.draczek.SystemOgloszeniowy.accountLink.domain.dto;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * AccountLinkDto dto.
 */
@Value
public class AccountLinkDto {
  UUID uuid;

  String name;

  String hyperlink;

  @NotNull
  Integer version;
}
