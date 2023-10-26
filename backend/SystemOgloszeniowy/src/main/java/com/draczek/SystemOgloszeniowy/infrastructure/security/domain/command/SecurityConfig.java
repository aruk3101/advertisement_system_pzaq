package com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Security config.
 */
@Configuration
class SecurityConfig {
  @Bean
  SecurityFacade securityFacade() {
    return new SecurityFacade(new SecurityContextHandler());
  }
}