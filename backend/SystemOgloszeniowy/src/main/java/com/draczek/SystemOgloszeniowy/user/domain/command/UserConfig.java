package com.draczek.SystemOgloszeniowy.user.domain.command;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Config class for UserFacade.
 */
@Configuration
public class UserConfig {

  @Bean
  UserFacade userFacade(UserRepository userRepository) {
    var userMapper = Mappers.getMapper(UserMapper.class);
    var searchUserUseCase = new SearchUserUseCase(userRepository, userMapper);

    return new UserFacade(searchUserUseCase);
  }
}
