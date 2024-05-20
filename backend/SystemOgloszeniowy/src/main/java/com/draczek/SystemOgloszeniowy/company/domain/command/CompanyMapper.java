package com.draczek.SystemOgloszeniowy.company.domain.command;

import com.draczek.SystemOgloszeniowy.company.domain.dto.CompanyDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

/**
 * Mapper Company.
 */
@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CompanyMapper {
  @Mappings({
  })
  CompanyDto toDto(Company company);
}
