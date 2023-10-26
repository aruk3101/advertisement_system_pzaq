package com.draczek.SystemOgloszeniowy.common.dto;

import com.draczek.SystemOgloszeniowy.common.entity.ErrorResponse;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * Default dto for exception handling.
 */
@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class DefaultErrorResponseDto extends ErrorResponse {
}