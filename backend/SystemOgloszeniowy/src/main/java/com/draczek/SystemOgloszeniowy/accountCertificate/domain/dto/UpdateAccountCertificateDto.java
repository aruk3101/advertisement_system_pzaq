package com.draczek.SystemOgloszeniowy.accountCertificate.domain.dto;

import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * UpdateAccountCertificateDto dto.
 */
@Value
public class UpdateAccountCertificateDto {
  String name;

  String host;

  Date date;

  @NotNull
  Integer version;
}
