package com.hexagonal.architecture.domain.repository;

import com.hexagonal.architecture.domain.entity.User;

import java.util.List;

public interface UserRepositoryInterface {
    User save(User user);
    List<User> findAll();
}
