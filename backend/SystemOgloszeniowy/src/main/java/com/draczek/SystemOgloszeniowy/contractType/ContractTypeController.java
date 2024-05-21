package com.draczek.SystemOgloszeniowy.contractType;

import com.draczek.SystemOgloszeniowy.contractType.domain.command.ContractTypeFacade;
import com.draczek.SystemOgloszeniowy.contractType.domain.dto.ContractTypeDto;
import com.draczek.SystemOgloszeniowy.contractType.domain.dto.CreateContractTypeDto;
import com.draczek.SystemOgloszeniowy.contractType.domain.dto.UpdateContractTypeDto;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * ContractType's package controller.
 */
@RestController
@RequestMapping(value = "/api/contractTypes")
@RequiredArgsConstructor
public class ContractTypeController {
  private final ContractTypeFacade contractTypeFacade;

  @GetMapping("")
  @Operation(summary = "Usługa do pobierania listy dostepnych w systemie"
      + " typów umów")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public List<ContractTypeDto> searchContractTypes() {
    return contractTypeFacade.search();
  }

  @PostMapping("")
  @Operation(summary = "Usługa do tworzenia nowych typów umów")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.CREATED)
  public ContractTypeDto createContractTypes(@RequestBody CreateContractTypeDto dto) {
    return contractTypeFacade.create(dto);
  }

  @DeleteMapping("/{uuid}")
  @Operation(summary = "Usługa do usuwania typów umów")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void deleteContractTypes(@PathVariable(name = "uuid") UUID uuid) {
    contractTypeFacade.delete(uuid);
  }

  @PutMapping("/{uuid}")
  @Operation(summary = "Usługa do modyfikacji typów umów")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void updateContractTypes(@PathVariable(name = "uuid") UUID uuid,
                                  @RequestBody UpdateContractTypeDto dto) {
    contractTypeFacade.update(uuid, dto);
  }
}
