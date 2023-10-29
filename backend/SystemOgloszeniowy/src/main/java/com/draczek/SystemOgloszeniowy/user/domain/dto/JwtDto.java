package com.draczek.SystemOgloszeniowy.user.domain.dto;

import java.util.Date;
import lombok.Value;

/**
 * JWT token's dto.
 */
@Value
public class JwtDto {
  String token;
  Date expiration;
}
