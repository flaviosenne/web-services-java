package com.hexagonal.architecture.infra.config.service;

import com.hexagonal.architecture.domain.protocols.UserServiceInterface;
import com.hexagonal.architecture.domain.repository.UserRepositoryInterface;
import com.hexagonal.architecture.domain.services.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfig {

    @Bean
    public UserServiceInterface userServiceInterface(UserRepositoryInterface repository){
        return new UserServiceImpl(repository);
    }
}
