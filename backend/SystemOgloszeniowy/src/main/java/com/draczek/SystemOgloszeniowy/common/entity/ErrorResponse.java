package com.draczek.SystemOgloszeniowy.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.experimental.SuperBuilder;

/**
 * Super class for Error response dtos.
 */
@SuperBuilder
public class ErrorResponse {
  String title;

  String code;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  LocalDateTime timestamp;
}
