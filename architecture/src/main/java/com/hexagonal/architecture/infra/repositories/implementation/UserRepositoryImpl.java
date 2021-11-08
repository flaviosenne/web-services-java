package com.hexagonal.architecture.infra.repositories.implementation;

import com.hexagonal.architecture.domain.entity.User;
import com.hexagonal.architecture.domain.repository.UserRepositoryInterface;
import com.hexagonal.architecture.infra.config.entity.UserEntity;
import com.hexagonal.architecture.infra.repositories.jpa.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserRepositoryImpl implements UserRepositoryInterface {
    private final UserRepository repository;

    @Override
    public User save(User user) {
        UserEntity entity =  new UserEntity().toEntity(user);
        return UserEntity.toUser(repository.save(entity));
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> users =  repository.findAll();

        return users.isEmpty()
                ? Collections.emptyList()
                : users.stream()
                .map(UserEntity::toUser)
                .collect(Collectors.toList());
    }
}
