package com.draczek.SystemOgloszeniowy.accountLink.domain.command;

import com.draczek.SystemOgloszeniowy.accountLink.domain.dto.AccountLinkDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

/**
 * Mapper AccountLink.
 */
@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AccountLinkMapper {
  @Mappings({
  })
  AccountLinkDto toDto(AccountLink accountLink);
}
