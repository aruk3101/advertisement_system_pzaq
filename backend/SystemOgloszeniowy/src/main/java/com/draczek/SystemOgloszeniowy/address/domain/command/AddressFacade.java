package com.draczek.SystemOgloszeniowy.address.domain.command;

import com.draczek.SystemOgloszeniowy.address.domain.dto.UpdateAddressDto;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * Address's package facade.
 */
@Validated
@RequiredArgsConstructor
@Transactional
public class AddressFacade {
  private final UpdateAddressUseCase updateAddressUseCase;

  /**
   * Method for updating logged in user's address.
   *
   * @param dto  UpdateAddressDto
   * @return modified AddressDto
   */
  public Address update(UpdateAddressDto dto) {
    return updateAddressUseCase.updateDto(dto);
  }
}
