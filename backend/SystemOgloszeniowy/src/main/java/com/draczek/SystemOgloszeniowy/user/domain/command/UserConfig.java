package com.draczek.SystemOgloszeniowy.user.domain.command;

import com.draczek.SystemOgloszeniowy.common.FileStorageService;
import com.draczek.SystemOgloszeniowy.common.FileUploadValidator;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Config class for UserFacade.
 */
@Configuration
class UserConfig {

  @Bean
  UserFacade userFacade(
      UserRepository userRepository,
      SecurityFacade securityFacade,
      PasswordEncoder passwordEncoder,
      FileStorageService fileStorageService) {
    UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    SearchUserUseCase searchUserUseCase = new SearchUserUseCase(userRepository,
        userMapper,
        securityFacade);

    CreateUserUseCase createUserUseCase = new CreateUserUseCase(userRepository);

    UserValidationHelper userValidationHelper = new UserValidationHelper(userRepository);

    FileUploadValidator fileUploadValidator = new FileUploadValidator();
    UpdateUserValidationHelper updateUserValidationHelper
        = new UpdateUserValidationHelper(fileUploadValidator);

    UpdateUserUseCase updateUserUseCase = new UpdateUserUseCase(
        userRepository,
        passwordEncoder,
        securityFacade,
        userMapper,
        updateUserValidationHelper,
        fileStorageService);

    return new UserFacade(
        searchUserUseCase,
        createUserUseCase,
        userValidationHelper,
        updateUserUseCase);
  }
}
