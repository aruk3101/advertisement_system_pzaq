package com.draczek.SystemOgloszeniowy.accountCertificate.domain.dto;

import java.util.Date;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * AccountCertificateDto dto.
 */
@Value
public class AccountCertificateDto {
  UUID uuid;

  String name;

  String host;

  Date date;

  @NotNull
  Integer version;
}

