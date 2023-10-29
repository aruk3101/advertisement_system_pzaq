package com.draczek.SystemOgloszeniowy.address.domain.dto;

import java.util.UUID;
import javax.validation.constraints.NotNull;
import lombok.Value;

/**
 * Address entity's dto.
 */
@Value
public class AddressDto {
  UUID uuid;

  String city;

  String postalName;

  String postalCode;

  String street;

  String streetNumber;

  String apartmentNumber;

  String country;

  @NotNull
  Integer version;
}
