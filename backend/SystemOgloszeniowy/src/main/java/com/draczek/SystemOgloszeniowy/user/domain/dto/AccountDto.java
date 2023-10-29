package com.draczek.SystemOgloszeniowy.user.domain.dto;

import java.util.Date;
import javax.validation.constraints.NotNull;

import com.draczek.SystemOgloszeniowy.address.domain.dto.AddressDto;
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

  AddressDto address;

  String profilePictureSource;

  @NotNull
  Integer version;
}
