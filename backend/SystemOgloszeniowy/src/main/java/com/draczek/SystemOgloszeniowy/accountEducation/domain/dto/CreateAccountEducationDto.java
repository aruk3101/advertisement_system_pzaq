package com.draczek.SystemOgloszeniowy.accountEducation.domain.dto;

import java.util.Date;
import java.util.UUID;
import lombok.Value;

/**
 * CreateAccountEducationDto dto.
 */
@Value
public class CreateAccountEducationDto {

  String schoolName;

  String schoolLocation;

  UUID educationLevelUuid;

  String specialization;

  Date periodStart;

  Date periodEnd;
}

