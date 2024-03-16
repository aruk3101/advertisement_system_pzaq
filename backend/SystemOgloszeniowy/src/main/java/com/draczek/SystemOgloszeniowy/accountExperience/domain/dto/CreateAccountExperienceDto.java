package com.draczek.SystemOgloszeniowy.accountExperience.domain.dto;

import com.draczek.SystemOgloszeniowy.accountExperiencesDuties.domain.dto.CreateAccountExperienceDutyDto;
import java.util.Date;
import java.util.List;
import lombok.Value;

/**
 * CreateAccountExperienceDto dto.
 */
@Value
public class CreateAccountExperienceDto {
  String position;

  String companyName;

  String location;

  Date periodStart;

  Date periodEnd;

  List<CreateAccountExperienceDutyDto> createAccountExperienceDutyDtos;
}
