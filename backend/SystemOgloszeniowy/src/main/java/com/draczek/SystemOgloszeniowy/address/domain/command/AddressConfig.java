package com.draczek.SystemOgloszeniowy.address.domain.command;

import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config class for AddressFacade.
 */
@Configuration
public class AddressConfig {
  @Bean
  AddressFacade addressFacade(
      AddressRepository addressRepository,
      SecurityFacade securityFacade
  ) {

    UpdateAddressUseCase updateAddressUseCase
        = new UpdateAddressUseCase(
        addressRepository,
        securityFacade);

    return new AddressFacade(updateAddressUseCase);
  }
}
