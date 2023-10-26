package com.draczek.SystemOgloszeniowy.role.domain.dto;

import com.draczek.SystemOgloszeniowy.role.domain.enumerated.RoleEnum;
import java.util.UUID;

/**
 * Role entity's dto.
 */
public record RoleDto(UUID uuid, RoleEnum name) {
}