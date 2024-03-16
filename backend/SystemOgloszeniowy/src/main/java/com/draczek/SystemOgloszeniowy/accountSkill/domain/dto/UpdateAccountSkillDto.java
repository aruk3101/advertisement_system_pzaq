package com.draczek.SystemOgloszeniowy.accountSkill.domain.dto;

import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * UpdateAccountSkillDto dto.
 */
@Value
public class UpdateAccountSkillDto {
  String skillName;

  @NotNull
  Integer version;
}