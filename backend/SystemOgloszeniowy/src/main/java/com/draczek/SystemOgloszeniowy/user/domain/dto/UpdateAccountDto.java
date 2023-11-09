package com.draczek.SystemOgloszeniowy.user.domain.dto;

import com.draczek.SystemOgloszeniowy.address.domain.dto.UpdateAddressDto;
import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * Update Account dto.
 */
@Value
public class UpdateAccountDto {
  String firstName;

  String lastName;

  Date birthDate;

  String phoneNumber;

  UpdateAddressDto updateAddressDto;

  @NotNull
  Integer version;
}
