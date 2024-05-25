package com.draczek.SystemOgloszeniowy.jobType;

import com.draczek.SystemOgloszeniowy.jobType.domain.command.JobTypeFacade;
import com.draczek.SystemOgloszeniowy.jobType.domain.dto.CreateJobTypeDto;
import com.draczek.SystemOgloszeniowy.jobType.domain.dto.JobTypeDto;
import com.draczek.SystemOgloszeniowy.jobType.domain.dto.UpdateJobTypeDto;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * JobType's package controller.
 */
@RestController
@RequestMapping(value = "/api/JobTypes")
@RequiredArgsConstructor
public class JobTypeController {
  private final JobTypeFacade jobTypeFacade;

  @GetMapping("")
  @Operation(summary = "Usługa do pobierania listy dostepnych w systemie"
      + " typów prac")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public List<JobTypeDto> searchJobTypes() {
    return jobTypeFacade.search();
  }

  @PostMapping("")
  @Operation(summary = "Usługa do tworzenia nowych typów prac")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.CREATED)
  public JobTypeDto createJobTypes(@RequestBody CreateJobTypeDto dto) {
    return jobTypeFacade.create(dto);
  }

  @DeleteMapping("/{uuid}")
  @Operation(summary = "Usługa do usuwania typów prac")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void deleteJobTypes(@PathVariable(name = "uuid") UUID uuid) {
    jobTypeFacade.delete(uuid);
  }

  @PutMapping("/{uuid}")
  @Operation(summary = "Usługa do modyfikacji typów prac")
  @PreAuthorize("hasRole('ADMIN') or hasRole('SUPER_ADMIN')")
  @ResponseStatus(HttpStatus.OK)
  public void updateJobTypes(@PathVariable(name = "uuid") UUID uuid,
                             @RequestBody UpdateJobTypeDto dto) {
    jobTypeFacade.update(uuid, dto);
  }
}