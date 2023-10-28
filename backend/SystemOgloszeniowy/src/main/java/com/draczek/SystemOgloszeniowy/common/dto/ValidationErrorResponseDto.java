package com.draczek.SystemOgloszeniowy.common.dto;

import com.draczek.SystemOgloszeniowy.common.entity.ErrorResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

/**
 * Dto for validation error handling.
 */
@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ValidationErrorResponseDto extends ErrorResponse {
  UUID uuid;

  @JsonProperty(value = "violations")
  List<ViolationDto> violations;
}