package com.draczek.SystemOgloszeniowy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
class SystemOgloszeniowyApplication extends SpringBootServletInitializer implements
    WebApplicationInitializer {

  public static void main(String[] args) {
    SpringApplication.run(SystemOgloszeniowyApplication.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(SystemOgloszeniowyApplication.class);
  }
}
