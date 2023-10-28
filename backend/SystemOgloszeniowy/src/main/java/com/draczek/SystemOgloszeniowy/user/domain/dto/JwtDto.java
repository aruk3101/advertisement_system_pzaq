package com.draczek.SystemOgloszeniowy.user.domain.dto;

import java.util.Date;

/**
 * JWT token's dto.
 */
public record JwtDto(String token, Date expiration) {

}
