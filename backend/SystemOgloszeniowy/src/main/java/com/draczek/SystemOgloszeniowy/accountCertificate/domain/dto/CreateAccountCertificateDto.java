package com.draczek.SystemOgloszeniowy.accountCertificate.domain.dto;

import java.util.Date;
import lombok.Value;

/**
 * CreateAccountCertificateDto dto.
 */
@Value
public class CreateAccountCertificateDto {

  String name;

  String host;

  Date date;
}

