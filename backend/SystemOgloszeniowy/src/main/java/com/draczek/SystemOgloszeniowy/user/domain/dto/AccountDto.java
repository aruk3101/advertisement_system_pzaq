package com.draczek.SystemOgloszeniowy.user.domain.dto;

import com.draczek.SystemOgloszeniowy.accountCertificate.domain.dto.AccountCertificateDto;
import com.draczek.SystemOgloszeniowy.accountEducation.domain.dto.AccountEducationDto;
import com.draczek.SystemOgloszeniowy.accountExperience.domain.dto.AccountExperienceDto;
import com.draczek.SystemOgloszeniowy.accountLanguage.domain.dto.AccountLanguageDto;
import com.draczek.SystemOgloszeniowy.accountLink.domain.dto.AccountLinkDto;
import com.draczek.SystemOgloszeniowy.accountSkill.domain.dto.AccountSkillDto;
import com.draczek.SystemOgloszeniowy.address.domain.dto.AddressDto;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * Account dto.
 */
@Value
public class AccountDto {
  String firstName;

  String lastName;

  Date birthDate;

  String phoneNumber;

  String careerSummary;

  String currentPosition;

  AddressDto address;

  String profilePictureSource;

  List<AccountCertificateDto> accountCertificates;

  List<AccountLinkDto> accountLinks;

  List<AccountSkillDto> accountSkills;

  List<AccountEducationDto> accountEducations;

  List<AccountExperienceDto> accountExperiences;

  List<AccountLanguageDto> accountLanguages;

  @NotNull
  Integer version;
}
