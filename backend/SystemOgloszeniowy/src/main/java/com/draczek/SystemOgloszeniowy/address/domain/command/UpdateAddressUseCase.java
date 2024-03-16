package com.draczek.SystemOgloszeniowy.address.domain.command;

import com.draczek.SystemOgloszeniowy.address.domain.dto.UpdateAddressDto;
import com.draczek.SystemOgloszeniowy.common.enumerated.StatusEnum;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import java.util.UUID;
import lombok.RequiredArgsConstructor;

/**
 * UseCase for updating addresses.
 */
@RequiredArgsConstructor
public class UpdateAddressUseCase {
  private final AddressRepository addressRepository;
  private final SecurityFacade securityFacade;

  /**
   * Method for updating Addresses.
   *
   * @param dto UpdateAddressDto
   * @return modified AddressDto
   */
  public Address updateDto(UpdateAddressDto dto) {
    return update(dto);
  }

  private Address update(UpdateAddressDto dto) {
    Address address = securityFacade.getLoggedInAccount().getAddress();
    if (address == null) {
      address = Address.builder()
          .uuid(UUID.randomUUID())
          .city(dto.getCity())
          .postalCode(dto.getPostalCode())
          .postalName(dto.getPostalName())
          .street(dto.getStreet())
          .streetNumber(dto.getStreetNumber())
          .apartmentNumber(dto.getApartmentNumber())
          .country(dto.getCountry())
          .build();
      address.setStatus(StatusEnum.ACTIVE);
      address.setUserIdCreated(securityFacade.getLoggedInUser().getId());
      address.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    } else {
      address.setCity(dto.getCity());
      address.setPostalCode(dto.getPostalCode());
      address.setPostalName(dto.getPostalName());
      address.setStreet(dto.getStreet());
      address.setStreetNumber(dto.getStreetNumber());
      address.setApartmentNumber(dto.getApartmentNumber());
      address.setCountry(dto.getCountry());
      address.setVersion(dto.getVersion());
      address.setUserIdLastModified(securityFacade.getLoggedInUser().getId());
    }
    return addressRepository.saveAndFlush(address);
  }
}
