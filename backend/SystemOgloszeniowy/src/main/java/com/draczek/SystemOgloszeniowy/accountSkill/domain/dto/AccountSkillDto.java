package com.draczek.SystemOgloszeniowy.accountSkill.domain.dto;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * AccountSkillDto dto.
 */
@Value
public class AccountSkillDto {
  UUID uuid;

  String skillName;

  @NotNull
  Integer version;
}
