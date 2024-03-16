package com.draczek.SystemOgloszeniowy.accountExperience.domain.dto;

import com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.dto.AccountExperienceDutyDto;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * AccountExperienceDto dto.
 */
@Value
public class AccountExperienceDto {
  UUID uuid;

  String position;

  String companyName;

  String location;

  Date periodStart;

  Date periodEnd;

  List<AccountExperienceDutyDto> accountExperienceDuties;

  @NotNull
  Integer version;
}
