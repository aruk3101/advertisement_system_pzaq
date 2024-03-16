package com.draczek.SystemOgloszeniowy.user.domain.command;

import com.draczek.SystemOgloszeniowy.address.domain.command.AddressFacade;
import com.draczek.SystemOgloszeniowy.common.FileStorageService;
import com.draczek.SystemOgloszeniowy.common.FileUploadValidator;
import com.draczek.SystemOgloszeniowy.infrastructure.security.domain.command.SecurityFacade;
import com.draczek.SystemOgloszeniowy.role.domain.command.RoleFacade;
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
      FileStorageService fileStorageService,
      RoleFacade roleFacade,
      AddressFacade addressFacade) {
    UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    SearchUserUseCase searchUserUseCase = new SearchUserUseCase(userRepository,
        userMapper,
        securityFacade);

    CreateUserUseCase createUserUseCase = new CreateUserUseCase(
        userRepository,
        passwordEncoder,
        roleFacade);

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
        fileStorageService,
        addressFacade);

    return new UserFacade(
        searchUserUseCase,
        createUserUseCase,
        userValidationHelper,
        updateUserUseCase);
  }
}
