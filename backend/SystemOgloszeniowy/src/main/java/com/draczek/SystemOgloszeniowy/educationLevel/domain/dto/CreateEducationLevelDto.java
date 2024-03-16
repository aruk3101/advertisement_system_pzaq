package com.draczek.SystemOgloszeniowy.educationLevel.domain.dto;

import javax.validation.constraints.NotBlank;
import lombok.Value;

/**
 * Dto for creating Education levels.
 */
@Value
public class CreateEducationLevelDto {
  @NotBlank
  String name;
}
