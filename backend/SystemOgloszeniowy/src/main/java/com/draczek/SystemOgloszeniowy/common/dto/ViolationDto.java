package com.draczek.SystemOgloszeniowy.common.dto;

import javax.validation.constraints.NotNull;

/**
 * Dto of validation violation.
 */
public record ViolationDto(@NotNull String code, @NotNull String name, @NotNull String reason) {

}