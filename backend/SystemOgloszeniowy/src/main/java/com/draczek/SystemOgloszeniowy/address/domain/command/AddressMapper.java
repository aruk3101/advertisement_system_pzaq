package com.draczek.SystemOgloszeniowy.address.domain.command;

import com.draczek.SystemOgloszeniowy.address.domain.dto.AddressDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

/**
 * Mapper Address.
 */
@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AddressMapper {
  @Mappings({
  })
  AddressDto toDto(Address address);
}
